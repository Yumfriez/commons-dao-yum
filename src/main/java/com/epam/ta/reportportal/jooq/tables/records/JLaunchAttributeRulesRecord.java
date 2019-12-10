/*
 * This file is generated by jOOQ.
 */
package com.epam.ta.reportportal.jooq.tables.records;


import com.epam.ta.reportportal.jooq.tables.JLaunchAttributeRules;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


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
public class JLaunchAttributeRulesRecord extends UpdatableRecordImpl<JLaunchAttributeRulesRecord> implements Record4<Long, Long, String, String> {

    private static final long serialVersionUID = -1258772549;

    /**
     * Setter for <code>public.launch_attribute_rules.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.launch_attribute_rules.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.launch_attribute_rules.sender_case_id</code>.
     */
    public void setSenderCaseId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.launch_attribute_rules.sender_case_id</code>.
     */
    public Long getSenderCaseId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.launch_attribute_rules.key</code>.
     */
    public void setKey(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.launch_attribute_rules.key</code>.
     */
    public String getKey() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.launch_attribute_rules.value</code>.
     */
    public void setValue(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.launch_attribute_rules.value</code>.
     */
    public String getValue() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Long, Long, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Long, Long, String, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return JLaunchAttributeRules.LAUNCH_ATTRIBUTE_RULES.ID;
    }

    @Override
    public Field<Long> field2() {
        return JLaunchAttributeRules.LAUNCH_ATTRIBUTE_RULES.SENDER_CASE_ID;
    }

    @Override
    public Field<String> field3() {
        return JLaunchAttributeRules.LAUNCH_ATTRIBUTE_RULES.KEY;
    }

    @Override
    public Field<String> field4() {
        return JLaunchAttributeRules.LAUNCH_ATTRIBUTE_RULES.VALUE;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Long component2() {
        return getSenderCaseId();
    }

    @Override
    public String component3() {
        return getKey();
    }

    @Override
    public String component4() {
        return getValue();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public Long value2() {
        return getSenderCaseId();
    }

    @Override
    public String value3() {
        return getKey();
    }

    @Override
    public String value4() {
        return getValue();
    }

    @Override
    public JLaunchAttributeRulesRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public JLaunchAttributeRulesRecord value2(Long value) {
        setSenderCaseId(value);
        return this;
    }

    @Override
    public JLaunchAttributeRulesRecord value3(String value) {
        setKey(value);
        return this;
    }

    @Override
    public JLaunchAttributeRulesRecord value4(String value) {
        setValue(value);
        return this;
    }

    @Override
    public JLaunchAttributeRulesRecord values(Long value1, Long value2, String value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached JLaunchAttributeRulesRecord
     */
    public JLaunchAttributeRulesRecord() {
        super(JLaunchAttributeRules.LAUNCH_ATTRIBUTE_RULES);
    }

    /**
     * Create a detached, initialised JLaunchAttributeRulesRecord
     */
    public JLaunchAttributeRulesRecord(Long id, Long senderCaseId, String key, String value) {
        super(JLaunchAttributeRules.LAUNCH_ATTRIBUTE_RULES);

        set(0, id);
        set(1, senderCaseId);
        set(2, key);
        set(3, value);
    }
}
