/*
 * This file is generated by jOOQ.
 */
package com.epam.ta.reportportal.jooq.tables;


import com.epam.ta.reportportal.jooq.Indexes;
import com.epam.ta.reportportal.jooq.JPublic;
import com.epam.ta.reportportal.jooq.Keys;
import com.epam.ta.reportportal.jooq.tables.records.JAuthConfigRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
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
public class JAuthConfig extends TableImpl<JAuthConfigRecord> {

    private static final long serialVersionUID = 872586617;

    /**
     * The reference instance of <code>public.auth_config</code>
     */
    public static final JAuthConfig AUTH_CONFIG = new JAuthConfig();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JAuthConfigRecord> getRecordType() {
        return JAuthConfigRecord.class;
    }

    /**
     * The column <code>public.auth_config.id</code>.
     */
    public final TableField<JAuthConfigRecord, String> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.auth_config.ldap_config_id</code>.
     */
    public final TableField<JAuthConfigRecord, Long> LDAP_CONFIG_ID = createField(DSL.name("ldap_config_id"), org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.auth_config.active_directory_config_id</code>.
     */
    public final TableField<JAuthConfigRecord, Long> ACTIVE_DIRECTORY_CONFIG_ID = createField(DSL.name("active_directory_config_id"), org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * Create a <code>public.auth_config</code> table reference
     */
    public JAuthConfig() {
        this(DSL.name("auth_config"), null);
    }

    /**
     * Create an aliased <code>public.auth_config</code> table reference
     */
    public JAuthConfig(String alias) {
        this(DSL.name(alias), AUTH_CONFIG);
    }

    /**
     * Create an aliased <code>public.auth_config</code> table reference
     */
    public JAuthConfig(Name alias) {
        this(alias, AUTH_CONFIG);
    }

    private JAuthConfig(Name alias, Table<JAuthConfigRecord> aliased) {
        this(alias, aliased, null);
    }

    private JAuthConfig(Name alias, Table<JAuthConfigRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> JAuthConfig(Table<O> child, ForeignKey<O, JAuthConfigRecord> key) {
        super(child, key, AUTH_CONFIG);
    }

    @Override
    public Schema getSchema() {
        return JPublic.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.AUTH_CONFIG_PK);
    }

    @Override
    public UniqueKey<JAuthConfigRecord> getPrimaryKey() {
        return Keys.AUTH_CONFIG_PK;
    }

    @Override
    public List<UniqueKey<JAuthConfigRecord>> getKeys() {
        return Arrays.<UniqueKey<JAuthConfigRecord>>asList(Keys.AUTH_CONFIG_PK);
    }

    @Override
    public List<ForeignKey<JAuthConfigRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<JAuthConfigRecord, ?>>asList(Keys.AUTH_CONFIG__AUTH_CONFIG_LDAP_CONFIG_ID_FKEY, Keys.AUTH_CONFIG__AUTH_CONFIG_ACTIVE_DIRECTORY_CONFIG_ID_FKEY);
    }

    public JLdapConfig ldapConfig() {
        return new JLdapConfig(this, Keys.AUTH_CONFIG__AUTH_CONFIG_LDAP_CONFIG_ID_FKEY);
    }

    public JActiveDirectoryConfig activeDirectoryConfig() {
        return new JActiveDirectoryConfig(this, Keys.AUTH_CONFIG__AUTH_CONFIG_ACTIVE_DIRECTORY_CONFIG_ID_FKEY);
    }

    @Override
    public JAuthConfig as(String alias) {
        return new JAuthConfig(DSL.name(alias), this);
    }

    @Override
    public JAuthConfig as(Name alias) {
        return new JAuthConfig(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public JAuthConfig rename(String name) {
        return new JAuthConfig(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JAuthConfig rename(Name name) {
        return new JAuthConfig(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<String, Long, Long> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}
