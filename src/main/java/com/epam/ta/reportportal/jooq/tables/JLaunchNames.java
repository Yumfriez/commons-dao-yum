/*
 * This file is generated by jOOQ.
 */
package com.epam.ta.reportportal.jooq.tables;

import com.epam.ta.reportportal.jooq.Indexes;
import com.epam.ta.reportportal.jooq.JPublic;
import com.epam.ta.reportportal.jooq.Keys;
import com.epam.ta.reportportal.jooq.tables.records.JLaunchNamesRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;
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
public class JLaunchNames extends TableImpl<JLaunchNamesRecord> {

    private static final long serialVersionUID = 510289900;

    /**
     * The reference instance of <code>public.launch_names</code>
     */
    public static final JLaunchNames LAUNCH_NAMES = new JLaunchNames();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JLaunchNamesRecord> getRecordType() {
        return JLaunchNamesRecord.class;
    }

    /**
     * The column <code>public.launch_names.sender_case_id</code>.
     */
    public final TableField<JLaunchNamesRecord, Long> SENDER_CASE_ID = createField("sender_case_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.launch_names.launch_name</code>.
     */
    public final TableField<JLaunchNamesRecord, String> LAUNCH_NAME = createField("launch_name", org.jooq.impl.SQLDataType.VARCHAR(256), this, "");

    /**
     * Create a <code>public.launch_names</code> table reference
     */
    public JLaunchNames() {
        this(DSL.name("launch_names"), null);
    }

    /**
     * Create an aliased <code>public.launch_names</code> table reference
     */
    public JLaunchNames(String alias) {
        this(DSL.name(alias), LAUNCH_NAMES);
    }

    /**
     * Create an aliased <code>public.launch_names</code> table reference
     */
    public JLaunchNames(Name alias) {
        this(alias, LAUNCH_NAMES);
    }

    private JLaunchNames(Name alias, Table<JLaunchNamesRecord> aliased) {
        this(alias, aliased, null);
    }

    private JLaunchNames(Name alias, Table<JLaunchNamesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> JLaunchNames(Table<O> child, ForeignKey<O, JLaunchNamesRecord> key) {
        super(child, key, LAUNCH_NAMES);
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
        return Arrays.<Index>asList(Indexes.LN_SEND_CASE_IDX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<JLaunchNamesRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<JLaunchNamesRecord, ?>>asList(Keys.LAUNCH_NAMES__LAUNCH_NAMES_SENDER_CASE_ID_FKEY);
    }

    public JSenderCase senderCase() {
        return new JSenderCase(this, Keys.LAUNCH_NAMES__LAUNCH_NAMES_SENDER_CASE_ID_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JLaunchNames as(String alias) {
        return new JLaunchNames(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JLaunchNames as(Name alias) {
        return new JLaunchNames(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public JLaunchNames rename(String name) {
        return new JLaunchNames(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JLaunchNames rename(Name name) {
        return new JLaunchNames(name, null);
    }
}
