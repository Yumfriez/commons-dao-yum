/*
 * Copyright 2018 EPAM Systems
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.epam.ta.reportportal.util;

import com.epam.ta.reportportal.commons.querygen.FilterTarget;
import org.jooq.Field;
import org.jooq.SortField;
import org.jooq.impl.DSL;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Sort;

import java.util.List;

import static com.epam.ta.reportportal.dao.constant.WidgetContentRepositoryConstants.*;
import static com.epam.ta.reportportal.dao.util.JooqFieldNameTransformer.fieldName;
import static com.epam.ta.reportportal.jooq.tables.JLaunch.LAUNCH;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class WidgetSortUtilsTest {

	private Sort sort;
	private FilterTarget filterTarget;

	@Before
	public void setUp() {

		sort = Sort.by("startTime", "name", "statistics$defects$to_investigate$ti001", "statistics$defects$system_issue$si001");
		filterTarget = FilterTarget.LAUNCH_TARGET;
	}

	@Test
	public void widgetSortTest() {
		List<SortField<Object>> sortFields = WidgetSortUtils.TO_SORT_FIELDS.apply(sort, filterTarget);

		Assert.assertEquals(LAUNCH.START_TIME.getQualifiedName().toString(), sortFields.get(0).getName());
		Assert.assertEquals(LAUNCH.NAME.getQualifiedName().toString(), sortFields.get(1).getName());

		Assert.assertEquals(DSL.coalesce(DSL.max(fieldName(STATISTICS_TABLE, STATISTICS_COUNTER))
				.filterWhere(fieldName(STATISTICS_TABLE, SF_NAME).cast(String.class).eq("statistics$defects$to_investigate$ti001")), 0)
				.toString(), sortFields.get(2).getName());

		Assert.assertEquals(DSL.coalesce(DSL.max(fieldName(STATISTICS_TABLE, STATISTICS_COUNTER))
				.filterWhere(fieldName(STATISTICS_TABLE, SF_NAME).cast(String.class).eq("statistics$defects$system_issue$si001")), 0)
				.toString(), sortFields.get(3).getName());
	}

	@Test
	public void widgetGroupingTest() {
		List<Field<Object>> sortFields = WidgetSortUtils.TO_GROUP_FIELDS.apply(sort, filterTarget);

		Assert.assertEquals(2, sortFields.size());
		Assert.assertEquals(LAUNCH.START_TIME.getQualifiedName().toString(), sortFields.get(0).getName());
		Assert.assertEquals(LAUNCH.NAME.getQualifiedName().toString(), sortFields.get(1).getName());
	}

}