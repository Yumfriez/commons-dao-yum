package com.epam.ta.reportportal.dao;

import com.epam.ta.reportportal.commons.querygen.Filter;
import com.epam.ta.reportportal.entity.filter.Queryable;
import com.epam.ta.reportportal.entity.launch.LaunchTag;
import com.epam.ta.reportportal.entity.widget.content.*;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Map;

/**
 * @author Pavel Bortnik
 */
public interface WidgetContentRepository {

	/**
	 * Overall statistics content loading.
	 *
	 * @param filter {@link Filter}
	 * @return List of {@link StatisticsContent}
	 */
	List<StatisticsContent> overallStatisticsContent(Filter filter, List<String> contentFields, boolean latestMode, int limit);

	/**
	 * Most failed content loading by execution status criteria.
	 *
	 * @param launchName Launch name
	 * @param criteria   Execution criteria
	 * @param limit      Results limit
	 * @return List of {@link MostFailedContent}
	 */
	List<MostFailedContent> mostFailedByExecutionCriteria(String launchName, String criteria, int limit);

	/**
	 * Most failed content loading by defect status criteria.
	 *
	 * @param launchName Launch name
	 * @param criteria   Defect criteria
	 * @param limit      Results limit
	 * @return List of {@link MostFailedContent}
	 */
	List<MostFailedContent> mostFailedByDefectCriteria(String launchName, String criteria, int limit);

	/**
	 * Launch statistics content loading
	 *
	 * @param filter        {@link Filter}
	 * @param contentFields Custom fields for select query building
	 * @param sort          {@link Sort}
	 * @param limit         Results limit
	 * @return List of {@link LaunchesStatisticsContent}
	 */
	List<LaunchesStatisticsContent> launchStatistics(Filter filter, List<String> contentFields, Sort sort, int limit);

	/**
	 * Investigated statistics loading
	 *
	 * @param filter {@link Filter}
	 * @param sort   {@link Sort}
	 * @param limit  Results limit
	 * @return List of{@link InvestigatedStatisticsResult}
	 */
	List<InvestigatedStatisticsResult> investigatedStatistics(Filter filter, Sort sort, int limit);

	/**
	 * Launches passing rate result for launch or for all launches depending on the filter conditions
	 *
	 * @param filter {@link Filter}
	 * @param sort   {@link Sort}
	 * @param limit  Results limit
	 * @return {@link PassingRateStatisticsResult}
	 */
	PassingRateStatisticsResult passingRateStatistics(Filter filter, Sort sort, int limit);

	/**
	 * Test cases' count trend loading
	 *
	 * @param filter                {@link Filter}
	 * @param executionContentField Content field with table column name
	 * @param sort                  {@link Sort}
	 * @param limit                 Results limit
	 * @return List of{@link CasesTrendContent}
	 */
	List<CasesTrendContent> casesTrendStatistics(Filter filter, String executionContentField, Sort sort, int limit);

	/**
	 * Bug trend loading
	 *
	 * @param filter        {@link Filter}
	 * @param contentFields Custom fields for select query building
	 * @param sort          {@link Sort}
	 * @param limit         Results limit
	 * @return List of{@link LaunchesStatisticsContent}
	 */
	List<LaunchesStatisticsContent> bugTrendStatistics(Filter filter, List<String> contentFields, Sort sort, int limit);

	/**
	 * Comparison statistics content loading for launches with specified Ids
	 *
	 * @param filter        {@link Filter}
	 * @param contentFields Custom fields for select query building
	 * @param sort          {@link Sort}
	 * @param limit         Results limit
	 * @return List of{@link LaunchesStatisticsContent}
	 */
	List<LaunchesStatisticsContent> launchesComparisonStatistics(Filter filter, List<String> contentFields, Sort sort, int limit);

	/**
	 * Launches duration content loading
	 *
	 * @param filter   {@link Filter}
	 * @param sort     {@link Sort}
	 * @param isLatest Flag for retrieving only latest launches
	 * @param limit    Results limit
	 * @return List of{@link LaunchesDurationContent}
	 */
	List<LaunchesDurationContent> launchesDurationStatistics(Filter filter, Sort sort, boolean isLatest, int limit);

	/**
	 * Not passed cases content loading
	 *
	 * @param filter {@link Filter}
	 * @param sort   {@link Sort}
	 * @param limit  Results limit
	 * @return List of{@link NotPassedCasesContent}
	 */
	List<NotPassedCasesContent> notPassedCasesStatistics(Filter filter, Sort sort, int limit);

	/**
	 * Launches table content loading
	 *
	 * @param filter        {@link Filter}
	 * @param contentFields Custom fields for select query building
	 * @param sort          {@link Sort}
	 * @param limit         Results limit
	 * @return List of{@link LaunchesStatisticsContent}
	 */
	List<LaunchesStatisticsContent> launchesTableStatistics(Filter filter, List<String> contentFields, Sort sort, int limit);

	/**
	 * User activity content loading
	 *
	 * @param filter {@link Filter}
	 * @param sort   {@link Sort}
	 * @param limit  Results limit
	 * @return List of{@link ActivityContent}
	 */
	List<ActivityContent> activityStatistics(Filter filter, Sort sort, int limit);

	/**
	 * Loading unique bugs content that was produced by Bug Tracking System
	 *
	 * @param filter {@link Filter}
	 * @param limit  Results limit
	 * @return Map grouped by ticket id as key and List of {@link UniqueBugContent} as value
	 */
	Map<String, List<UniqueBugContent>> uniqueBugStatistics(Filter filter, int limit);

	/**
	 * Loading the most "flaky" test cases content
	 *
	 * @param filter {@link Filter}
	 * @param limit  Results limit
	 * @return List of {@link FlakyCasesTableContent}
	 */
	List<FlakyCasesTableContent> flakyCasesStatistics(Filter filter, int limit);

	/**
	 * @param filter        {@link Filter}
	 * @param contentFields Custom fields for select query building
	 * @param sort          {@link Sort}
	 * @param tagPrefix     Prefix of the {@link LaunchTag#getValue()}
	 * @param limit         Results limit
	 * @return Map with {@link LaunchTag#getValue()} as key and list of {@link LaunchesStatisticsContent} as value
	 */
	Map<String, List<LaunchesStatisticsContent>> cumulativeTrendStatistics(Filter filter, List<String> contentFields, Sort sort,
			String tagPrefix, int limit);

	/**
	 * @param filterSortMapping Map of {@link Filter} as key and {@link Sort} as value to implement multiple filters logic with own sorting
	 * @param contentFields     Custom fields for select query building
	 * @param tags              List of the prefixes of the {@link LaunchTag#getValue()}
	 * @param isLatest          Flag for retrieving only latest launches
	 * @param limit             Results limit
	 * @return Map grouped by filter name with {@link Queryable#getName()} as key and list of {@link LaunchesStatisticsContent} as value
	 */
	Map<String, List<LaunchesStatisticsContent>> productStatusGroupedByFilterStatistics(Map<Filter, Sort> filterSortMapping,
			List<String> contentFields, List<String> tags, boolean isLatest, int limit);

	/**
	 * @param filter        {@link Filter}
	 * @param contentFields Custom fields for select query building
	 * @param tags          List of the prefixes of the {@link LaunchTag#getValue()}
	 * @param sort          {@link Sort}
	 * @param isLatest      Flag for retrieving only latest launches
	 * @param limit         Results limit
	 * @return list of {@link LaunchesStatisticsContent}
	 */
	List<LaunchesStatisticsContent> productStatusGroupedByLaunchesStatistics(Filter filter, List<String> contentFields, List<String> tags,
			Sort sort, boolean isLatest, int limit);
}
