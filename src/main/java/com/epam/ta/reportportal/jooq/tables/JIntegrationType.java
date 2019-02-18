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

/*
 * This file is generated by jOOQ.
 */
package com.epam.ta.reportportal.jooq.tables;

import com.epam.ta.reportportal.jooq.Indexes;
import com.epam.ta.reportportal.jooq.JPublic;
import com.epam.ta.reportportal.jooq.Keys;
import com.epam.ta.reportportal.jooq.enums.JIntegrationAuthFlowEnum;
import com.epam.ta.reportportal.jooq.enums.JIntegrationGroupEnum;
import com.epam.ta.reportportal.jooq.tables.records.JIntegrationTypeRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JIntegrationType extends TableImpl<JIntegrationTypeRecord> {

	private static final long serialVersionUID = 906604102;

    /**
     * The reference instance of <code>public.integration_type</code>
     */
    public static final JIntegrationType INTEGRATION_TYPE = new JIntegrationType();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JIntegrationTypeRecord> getRecordType() {
        return JIntegrationTypeRecord.class;
    }

    /**
     * The column <code>public.integration_type.id</code>.
     */
    public final TableField<JIntegrationTypeRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('integration_type_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.integration_type.name</code>.
     */
    public final TableField<JIntegrationTypeRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR(128).nullable(false), this, "");

    /**
     * The column <code>public.integration_type.auth_flow</code>.
     */
    public final TableField<JIntegrationTypeRecord, JIntegrationAuthFlowEnum> AUTH_FLOW = createField("auth_flow", org.jooq.impl.SQLDataType.VARCHAR.asEnumDataType(com.epam.ta.reportportal.jooq.enums.JIntegrationAuthFlowEnum.class), this, "");

    /**
     * The column <code>public.integration_type.creation_date</code>.
     */
    public final TableField<JIntegrationTypeRecord, Timestamp> CREATION_DATE = createField("creation_date", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("now()", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>public.integration_type.group_type</code>.
     */
    public final TableField<JIntegrationTypeRecord, JIntegrationGroupEnum> GROUP_TYPE = createField("group_type", org.jooq.impl.SQLDataType.VARCHAR.nullable(false).asEnumDataType(com.epam.ta.reportportal.jooq.enums.JIntegrationGroupEnum.class), this, "");

	/**
	 * The column <code>public.integration_type.enabled</code>.
	 */
	public final TableField<JIntegrationTypeRecord, Boolean> ENABLED = createField(
			"enabled",
			org.jooq.impl.SQLDataType.BOOLEAN.nullable(false),
			this,
			""
	);

    /**
     * The column <code>public.integration_type.details</code>.
     */
    public final TableField<JIntegrationTypeRecord, Object> DETAILS = createField("details", org.jooq.impl.DefaultDataType.getDefaultDataType("\"pg_catalog\".\"jsonb\""), this, "");

    /**
     * Create a <code>public.integration_type</code> table reference
     */
    public JIntegrationType() {
        this(DSL.name("integration_type"), null);
    }

    /**
     * Create an aliased <code>public.integration_type</code> table reference
     */
    public JIntegrationType(String alias) {
        this(DSL.name(alias), INTEGRATION_TYPE);
    }

    /**
     * Create an aliased <code>public.integration_type</code> table reference
     */
    public JIntegrationType(Name alias) {
        this(alias, INTEGRATION_TYPE);
    }

    private JIntegrationType(Name alias, Table<JIntegrationTypeRecord> aliased) {
        this(alias, aliased, null);
    }

    private JIntegrationType(Name alias, Table<JIntegrationTypeRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> JIntegrationType(Table<O> child, ForeignKey<O, JIntegrationTypeRecord> key) {
        super(child, key, INTEGRATION_TYPE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return JPublic.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.INTEGRATION_TYPE_NAME_KEY, Indexes.INTEGRATION_TYPE_PK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<JIntegrationTypeRecord, Integer> getIdentity() {
        return Keys.IDENTITY_INTEGRATION_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<JIntegrationTypeRecord> getPrimaryKey() {
        return Keys.INTEGRATION_TYPE_PK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<JIntegrationTypeRecord>> getKeys() {
        return Arrays.<UniqueKey<JIntegrationTypeRecord>>asList(Keys.INTEGRATION_TYPE_PK, Keys.INTEGRATION_TYPE_NAME_KEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JIntegrationType as(String alias) {
        return new JIntegrationType(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JIntegrationType as(Name alias) {
        return new JIntegrationType(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public JIntegrationType rename(String name) {
        return new JIntegrationType(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JIntegrationType rename(Name name) {
        return new JIntegrationType(name, null);
    }
}
