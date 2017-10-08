/*
 * Copyright 2016 EPAM Systems
 * 
 * 
 * This file is part of EPAM Report Portal.
 * https://github.com/reportportal/commons-dao
 * 
 * Report Portal is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Report Portal is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Report Portal.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.epam.ta.reportportal.database.dao;

import com.epam.ta.reportportal.commons.DbUtils;
import com.epam.ta.reportportal.commons.MoreCollectors;
import com.epam.ta.reportportal.database.entity.*;
import com.epam.ta.reportportal.database.entity.history.status.FlakyHistoryObject;
import com.epam.ta.reportportal.database.entity.history.status.MostFailedHistoryObject;
import com.epam.ta.reportportal.database.entity.item.TestItem;
import com.epam.ta.reportportal.database.entity.item.TestItemType;
import com.epam.ta.reportportal.database.entity.item.issue.TestItemIssue;
import com.epam.ta.reportportal.database.entity.item.issue.TestItemIssueType;
import com.epam.ta.reportportal.database.entity.statistics.StatisticSubType;
import com.epam.ta.reportportal.database.search.ModifiableQueryBuilder;
import com.mongodb.BasicDBObject;
import org.apache.commons.collections.CollectionUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.Fields;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.time.Duration;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.StreamSupport;

import static com.epam.ta.reportportal.database.dao.aggregation.AddFieldsOperation.addFields;
import static com.epam.ta.reportportal.database.search.UpdateStatisticsQueryBuilder.*;
import static java.util.stream.Collectors.*;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Implementation of Test Items repository routines
 *
 * @author Andrei Varabyeu
 * @author Andrei_Ramanchuk
 */
public class TestItemRepositoryCustomImpl implements TestItemRepositoryCustom {

	private static final String ID_REFERENCE = "id";
	private static final String ID = "_id";
	private static final String LAUNCH_REFERENCE = "launchRef";
	private static final String ITEM_REFERENCE = "testItemRef";
	private static final String ISSUE_TYPE = "issue.issueType";
	private static final String ISSUE_TICKET = "issue.externalSystemIssues";
	private static final String ISSUE_DESCRIPTION = "issue.issueDescription";
	private static final String ISSUE = "issue";
	private static final String HAS_CHILD = "has_childs";
	private static final String START_TIME = "start_time";
	private static final String TYPE = "type";
	private static final String NAME = "name";
	private static final String STATUS = "status";
	private static final String PARENT = "parent";
	private static final String UNIQUE_ID = "uniqueId";
	private static final String CRITERIA_COUNT = "criteria_count";

	public static final int HISTORY_LIMIT = 2000;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void updateExecutionStatistics(TestItem item) {
		mongoTemplate.updateMulti(getItemQuery(item), fromItemStatusAware(item.getStatus(), 1, 1), TestItem.class);
	}

	@Override
	public void updateIssueStatistics(TestItem item, Project.Configuration settings) {
		mongoTemplate.updateMulti(getItemQuery(item),
				fromIssueTypeAware(settings.getByLocator(item.getIssue().getIssueType()), 1),
				TestItem.class
		);
	}

	@Override
	public void dropIssueStatisticsType(String id, StatisticSubType type) {
		mongoTemplate.updateMulti(query(where(ID_REFERENCE).is(id)), dropIssueTypeAware(type), TestItem.class);
	}

	@Override
	public void updateHasChilds(String id, boolean hasChildren) {
		mongoTemplate.updateFirst(query(where(ID_REFERENCE).is(id)), Update.update("has_childs", hasChildren), TestItem.class);
	}

	@Override
	public void updateItemsIssues(Map<String, TestItemIssue> forUpdate) {
		Query query = query(where(ID).in(forUpdate.keySet()));
		Update update = new Update();
		mongoTemplate.stream(query, TestItem.class).forEachRemaining(dbo -> {
			String currentId = dbo.getId();
			TestItemIssue newValue = forUpdate.get(currentId);
			update.set(ISSUE_TYPE, newValue.getIssueType());
			update.set(ISSUE_DESCRIPTION, newValue.getIssueDescription());
			update.set(ISSUE_TICKET, newValue.getExternalSystemIssues());
			mongoTemplate.updateFirst(Query.query(Criteria.where(ID).is(currentId)), update,
					mongoTemplate.getCollectionName(TestItem.class)
			);
		});
	}

	@Override
	public boolean hasDescendants(Object... id) {
		return mongoTemplate.count(getItemDescendantsQuery(id), TestItem.class) > 0;
	}

	@Override
	public List<TestItem> findDescendants(String... id) {
		return mongoTemplate.find(getItemDescendantsQuery((Object[]) id), TestItem.class);
	}

	@Override
	public void resetIssueStatistics(TestItem item, Project.Configuration settings) {
		mongoTemplate.updateMulti(getItemQuery(item),
				fromIssueTypeAware(settings.getByLocator(item.getIssue().getIssueType()), -1),
				TestItem.class
		);
	}

	@Override
	public void resetExecutionStatistics(TestItem item) {
		mongoTemplate.updateMulti(getItemQuery(item), fromItemStatusAware(item.getStatus(), -1, -1), TestItem.class);
	}

	@Override
	public void deleteIssueStatistics(TestItem item) {
		mongoTemplate.updateMulti(getItemQuery(item), fromIssueTypeAware(item), TestItem.class);
	}

	@Override
	public void deleteExecutionStatistics(TestItem item) {
		mongoTemplate.updateMulti(getItemQuery(item), fromItemStatusAware(item, true), TestItem.class);
	}

	private Query getItemQuery(TestItem item) {
		List<String> fullPath = new ArrayList<>(item.getPath());
		fullPath.add(item.getId());
		return query(where(LAUNCH_REFERENCE).is(item.getLaunchRef())).addCriteria(where("_id").in(fullPath))
				.addCriteria(where("statistics").exists(true));
	}

	private Query getItemDescendantsQuery(Object... id) {
		return new Query().addCriteria(where("path").in(id));
	}

	@Override
	public List<TestItem> findByLaunch(Launch launch) {
		return mongoTemplate.find(query(where(LAUNCH_REFERENCE).is(launch.getId())), TestItem.class);
	}

	@Override
	public List<TestItem> findIdsByLaunch(Iterable<Launch> launches) {
		Query q = query(where(LAUNCH_REFERENCE).in(obtainIds(launches)));
		q.fields().include(ID_REFERENCE);
		return mongoTemplate.find(q, TestItem.class);
	}

	@Override
	public Map<String, String> findPathNames(Iterable<String> path) {
		Query q = query(where("_id").in(toObjId(path)));
		q.fields().include("name");
		List<TestItem> testItems = mongoTemplate.find(q, TestItem.class);
		return testItems.stream().collect(MoreCollectors.toLinkedMap(TestItem::getId, TestItem::getName));
	}

	private Collection<ObjectId> toObjId(Iterable<String> path) {
		List<ObjectId> ids = new ArrayList<>();
		for (String id : path) {
			ids.add(new ObjectId(id));
		}
		return ids;
	}

	private Collection<String> obtainIds(Iterable<Launch> launches) {
		return StreamSupport.stream(launches.spliterator(), false).map(Launch::getId).collect(toList());
	}

	@Override
	public List<TestItem> findModifiedLaterAgo(Duration period, Status status, Launch launch, boolean hasChilds) {
		Query q = ModifiableQueryBuilder.findModifiedLaterThanPeriod(period, status)
				.addCriteria(where(LAUNCH_REFERENCE).is(launch.getId()))
				.addCriteria(where("has_childs").is(hasChilds));
		return mongoTemplate.find(q, TestItem.class);
	}

	@Override
	public List<TestItem> findModifiedLaterAgo(Duration period, Status status, Launch launch) {
		Query q = ModifiableQueryBuilder.findModifiedLaterThanPeriod(period, status)
				.addCriteria(where(LAUNCH_REFERENCE).is(launch.getId()));
		return mongoTemplate.find(q, TestItem.class);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<String> findDistinctValues(String launchId, String containsValue, String distinctBy) {
		Aggregation aggregation = newAggregation(match(where(LAUNCH_REFERENCE).is(launchId)),
				unwind(distinctBy),
				match(where(distinctBy).regex("(?i).*" + Pattern.quote(containsValue) + ".*")),
				group(distinctBy)
		);
		AggregationResults<Map> result = mongoTemplate.aggregate(aggregation, TestItem.class, Map.class);
		return result.getMappedResults().stream().map(entry -> entry.get("_id").toString()).collect(toList());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<String> getUniqueTicketsCount(List<Launch> launches) {
		List<String> launchIds = launches.stream().map(Launch::getId).collect(toList());
		Aggregation aggregation = newAggregation(match(where(LAUNCH_REFERENCE).in(launchIds)), match(where(ISSUE_TICKET).exists(true)),
				unwind(ISSUE_TICKET), group(ISSUE_TICKET)
		);
		// Count be as
		// Aggregation.group("issue.externalSystemIssues").count().as("count");
		// but keep a whole
		AggregationResults<Map> result = mongoTemplate.aggregate(aggregation, TestItem.class, Map.class);
		return result.getMappedResults().stream().map(entry -> entry.get("ticketId").toString()).collect(toList());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.epam.ta.reportportal.database.dao.TestItemRepositoryCustom#
	 * getMostFailedTestCases(java.util.List, java.lang.String)
	 *
	 * Most Failed Test Cases widget related method
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map<String, String> getMostFailedTestCases(List<Launch> launches, String criteria) {
		Map<String, String> output = new HashMap<>();
		List<String> launchIds = launches.stream().map(Launch::getId).collect(toList());

		GroupOperation operationTotal = new GroupOperation(Fields.fields("$name")).count().as("count");
		Aggregation aggregationTotal = newAggregation(match(where(LAUNCH_REFERENCE).in(launchIds)),
				match(where(HAS_CHILD).is(false)),
				operationTotal
		);
		AggregationResults<Map> resultTotal = mongoTemplate.aggregate(aggregationTotal, TestItem.class, Map.class);
		Map<String, String> values = resultTotal.getMappedResults()
				.stream()
				.collect(toMap(key -> key.get("_id").toString(), value -> value.get("count").toString()));

		GroupOperation operation = new GroupOperation(Fields.fields("$name")).count().as("count").last("$startTime").as("last");
		Aggregation aggregation = newAggregation(match(where(LAUNCH_REFERENCE).in(launchIds)),
				match(where(criteria).is(1)),
				match(where(HAS_CHILD).is(false)),
				operation
		);

		AggregationResults<Map> result = mongoTemplate.aggregate(aggregation, TestItem.class, Map.class);
		for (Map<String, ?> entry : result.getMappedResults()) {
			String itemName = String.valueOf(entry.get("_id"));
			String count = String.valueOf(entry.get("count"));
			Date date = (Date) entry.get("last");
			String total = values.get(itemName);
			// FIXME Update dirty # separator with common case
			// And update after {@link MostFailedTestCasesFilterStrategy}
			output.put(itemName, count + "#" + date.getTime() + "#" + total);
		}
		return output;
	}

	//@formatter:off



/*	db.testItem.aggregate([
    { "$match" : { "launchRef" : { "$in" : [""]}}},
    { "$match" : { "has_childs" : false}} ,
    { "$sort" : { "start_time" : 1}},
    { "$group" : {
            "_id" : "$uniqueId" ,
            "total" : { "$sum" : 1 },
            "name" : {"$first" : "$name"},
            "statusHistory" : { "$push" : {"status" : "$status", "issue" : "$issue.issueType", "time" : "$start_time"}},
            "criteria" : { "$sum" : "$statistics.executionCounter.failed"},
    }},
    { "$match" : { "criteria" : {"$gt" : 1}}},
    { "$sort" : { "criteria" : -1}},
    { "$limit" : 20}
])
*/
	@Override
	public List<MostFailedHistoryObject> getMostFailedItemHistory(List<String> launchIds, String criteria) {
		Aggregation aggregation = newAggregation(
				match(where(LAUNCH_REFERENCE).in(launchIds).and(HAS_CHILD).is(false)),
				sort(Sort.Direction.ASC, START_TIME),
				mostFailedGroup(criteria),
				match(where(CRITERIA_COUNT).gt(0)),
				sort(Sort.Direction.DESC, CRITERIA_COUNT),
				limit(20)
		);
		return mongoTemplate.aggregate(aggregation, mongoTemplate.getCollectionName(TestItem.class), MostFailedHistoryObject.class)
				.getMappedResults();
	}

	private GroupOperation mostFailedGroup(String criteria) {
		final String CRITERIA = "$" + criteria;
		return group(Fields.fields("$uniqueId"))
						.count().as("total")
						.first("$name").as("name")
						.push(new BasicDBObject("status", "$status")
								.append("issue", "$issue.issueType")
								.append("time", "$start_time")
								.append("criteria", CRITERIA))
						.as("statusHistory")
						.sum(CRITERIA).as(CRITERIA_COUNT);
	}

	/*
			db.testItem.aggregate([
				{ "$match" : { $and: [ "launchRef" : { "$in" : [""]}, has_childs : false ]}},
				{ "$sort" : { "start_time" : 1}},
				{ "$group" : {
					"_id" : "$uniqueId" ,
					"total" : { "$sum" : 1 },
					"statusHistory" : { "$push" : {"status" : "$status", "time" : "$start_time"}},
					"statusSet" : { "$addToSet" : "$status" },
					"name" : {"$first" : "$name"},
				}},
				{ "$addFields" : { "count" : {"$size" : "$statusSet" }}},
				{ "$match" : { "count" : {"$gt" : 1}}}
		])
	 */
	@Override
	public List<FlakyHistoryObject> getFlakyItemStatusHistory(List<String> launchIds) {
		Aggregation aggregation = newAggregation(
				match(where(LAUNCH_REFERENCE).in(launchIds).and(HAS_CHILD).is(false)),
				sort(Sort.Direction.ASC, START_TIME),
				flakyItemsGroup(),
				addFields("size", new BasicDBObject("$size", "$statusSet")),
				match(where("size").gt(1))
		);
		return mongoTemplate.aggregate(aggregation, mongoTemplate.getCollectionName(TestItem.class), FlakyHistoryObject.class)
				.getMappedResults();
	}

	private GroupOperation flakyItemsGroup() {
		return group(Fields.fields("$uniqueId"))
				.count().as("total")
				.first("$name").as("name")
				.push(new BasicDBObject("status", "$status")
						.append("time", "$start_time"))
				.as("statusHistory")
				.addToSet("$status").as("statusSet");
	}
	//@formatter:on

	@Override
	public boolean hasLogs(Iterable<TestItem> items) {
		Query query = query(where(ITEM_REFERENCE).in(DbUtils.toIds(items)));
		return mongoTemplate.count(query, Log.class) > 0;
	}

	@Override
	public List<TestItem> loadItemsHistory(List<String> uniqueIds, List<String> launchesIds) {
		if (CollectionUtils.isEmpty(uniqueIds) || CollectionUtils.isEmpty(launchesIds)) {
			return Collections.emptyList();
		}
		Query query = query(where(LAUNCH_REFERENCE).in(launchesIds).and(UNIQUE_ID).in(uniqueIds));
		query.limit(HISTORY_LIMIT);
		return mongoTemplate.find(query, TestItem.class);
	}

	@Override
	public boolean hasTestItemsAddedLately(Duration period, Launch launch, Status status) {
		Query query = ModifiableQueryBuilder.findModifiedLately(period)
				.addCriteria(where(LAUNCH_REFERENCE).is(launch.getId()))
				.addCriteria(where(HasStatus.STATUS).is(status.name()));
		return (mongoTemplate.count(query, TestItem.class) > 0);
	}

	@Override
	public List<TestItem> findInIssueTypeItems(String issueType, String launchId) {
		Query query = query(where(LAUNCH_REFERENCE).is(launchId)).addCriteria(where(ISSUE_TYPE).regex(Pattern.quote(issueType)));
		return mongoTemplate.find(query, TestItem.class);
	}

	@Override
	public List<String> findItemIdsByLaunchRef(List<String> launchRefs) {
		Aggregation aggregation = newAggregation(match(where(LAUNCH_REFERENCE).in(launchRefs)), group(ID_REFERENCE));
		AggregationResults<Map> aggregationResults = mongoTemplate.aggregate(aggregation, TestItem.class, Map.class);
		return aggregationResults.getMappedResults().stream().map(it -> it.get("_id").toString()).collect(toList());
	}

	@Override
	public List<TestItem> findItemsWithType(String launchId, TestItemType type) {
		Query query = query(where(LAUNCH_REFERENCE).is(launchId)).addCriteria(where(TYPE).is(type));
		return mongoTemplate.find(query, TestItem.class);
	}

	@Override
	public Set<String> findIdsWithNameByLaunchesRef(String name, Set<String> launchRef) {
		Query query = query(where(LAUNCH_REFERENCE).in(launchRef)).addCriteria(where(NAME).is(name));
		query.fields().include("_id");
		return mongoTemplate.find(query, TestItem.class).stream().map(TestItem::getId).collect(toSet());
	}

	@Override
	public List<TestItem> findByHasChildStatus(boolean hasChildren, String launch) {
		Query query = query(where(LAUNCH_REFERENCE).is(launch)).addCriteria(where(HAS_CHILD).is(hasChildren))
				.with(new Sort(Sort.Direction.ASC, START_TIME));
		return mongoTemplate.find(query, TestItem.class);
	}

	@Override
	public List<TestItem> findForSpecifiedSubType(List<String> launchesIds, boolean hasChild, StatisticSubType type) {
		String issueField =
				"statistics.issueCounter." + TestItemIssueType.valueOf(type.getTypeRef()).awareStatisticsField() + "." + type.getLocator();
		Query query = query(where(LAUNCH_REFERENCE).in(launchesIds)).addCriteria(where(HAS_CHILD).is(hasChild))
				.addCriteria(where(issueField).exists(true))
				.with(new Sort(Sort.Direction.ASC, START_TIME));
		return mongoTemplate.find(query, TestItem.class);
	}

	@Override
	public List<TestItem> findTestItemWithIssues(String launchId) {
		Criteria externalIssues = new Criteria().andOperator(where(LAUNCH_REFERENCE).is(launchId), where(ISSUE).exists(true));
		Query query = query(externalIssues);
		return mongoTemplate.find(query, TestItem.class);
	}

	@Override
	public boolean hasChildrenWithStatuses(String itemId, Status... statuses) {
		Query query = query(where(PARENT).is(itemId)).addCriteria(where(STATUS).in((Object[]) statuses));
		return mongoTemplate.count(query, TestItem.class) > 0;
	}

	@Override
	public List<TestItem> findWithoutParentByLaunchRef(String launchId) {
		Query query = query(where(PARENT).exists(false)).addCriteria(where(LAUNCH_REFERENCE).is(launchId));
		return mongoTemplate.find(query, TestItem.class);
	}
}
