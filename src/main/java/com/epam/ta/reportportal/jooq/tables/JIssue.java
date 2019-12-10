/*
 * This file is generated by jOOQ.
 */
package com.epam.ta.reportportal.jooq.tables;


import com.epam.ta.reportportal.jooq.Indexes;
import com.epam.ta.reportportal.jooq.JPublic;
import com.epam.ta.reportportal.jooq.Keys;
import com.epam.ta.reportportal.jooq.tables.records.JIssueRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row5;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JIssue extends TableImpl<JIssueRecord> {

    private static final long serialVersionUID = -1307854367;

    /**
     * The reference instance of <code>public.issue</code>
     */
    public static final JIssue ISSUE = new JIssue();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JIssueRecord> getRecordType() {
        return JIssueRecord.class;
    }

    /**
     * The column <code>public.issue.issue_id</code>.
     */
    public final TableField<JIssueRecord, Long> ISSUE_ID = createField(DSL.name("issue_id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.issue.issue_type</code>.
     */
    public final TableField<JIssueRecord, Long> ISSUE_TYPE = createField(DSL.name("issue_type"), org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.issue.issue_description</code>.
     */
    public final TableField<JIssueRecord, String> ISSUE_DESCRIPTION = createField(DSL.name("issue_description"), org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.issue.auto_analyzed</code>.
     */
    public final TableField<JIssueRecord, Boolean> AUTO_ANALYZED = createField(DSL.name("auto_analyzed"), org.jooq.impl.SQLDataType.BOOLEAN.defaultValue(org.jooq.impl.DSL.field("false", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>public.issue.ignore_analyzer</code>.
     */
    public final TableField<JIssueRecord, Boolean> IGNORE_ANALYZER = createField(DSL.name("ignore_analyzer"), org.jooq.impl.SQLDataType.BOOLEAN.defaultValue(org.jooq.impl.DSL.field("false", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * Create a <code>public.issue</code> table reference
     */
    public JIssue() {
        this(DSL.name("issue"), null);
    }

    /**
     * Create an aliased <code>public.issue</code> table reference
     */
    public JIssue(String alias) {
        this(DSL.name(alias), ISSUE);
    }

    /**
     * Create an aliased <code>public.issue</code> table reference
     */
    public JIssue(Name alias) {
        this(alias, ISSUE);
    }

    private JIssue(Name alias, Table<JIssueRecord> aliased) {
        this(alias, aliased, null);
    }

    private JIssue(Name alias, Table<JIssueRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> JIssue(Table<O> child, ForeignKey<O, JIssueRecord> key) {
        super(child, key, ISSUE);
    }

    @Override
    public Schema getSchema() {
        return JPublic.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.ISSUE_IT_IDX, Indexes.ISSUE_PK);
    }

    @Override
    public UniqueKey<JIssueRecord> getPrimaryKey() {
        return Keys.ISSUE_PK;
    }

    @Override
    public List<UniqueKey<JIssueRecord>> getKeys() {
        return Arrays.<UniqueKey<JIssueRecord>>asList(Keys.ISSUE_PK);
    }

    @Override
    public List<ForeignKey<JIssueRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<JIssueRecord, ?>>asList(Keys.ISSUE__ISSUE_ISSUE_ID_FKEY, Keys.ISSUE__ISSUE_ISSUE_TYPE_FKEY);
    }

    public JTestItemResults testItemResults() {
        return new JTestItemResults(this, Keys.ISSUE__ISSUE_ISSUE_ID_FKEY);
    }

    public JIssueType issueType() {
        return new JIssueType(this, Keys.ISSUE__ISSUE_ISSUE_TYPE_FKEY);
    }

    @Override
    public JIssue as(String alias) {
        return new JIssue(DSL.name(alias), this);
    }

    @Override
    public JIssue as(Name alias) {
        return new JIssue(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public JIssue rename(String name) {
        return new JIssue(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JIssue rename(Name name) {
        return new JIssue(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Long, Long, String, Boolean, Boolean> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
