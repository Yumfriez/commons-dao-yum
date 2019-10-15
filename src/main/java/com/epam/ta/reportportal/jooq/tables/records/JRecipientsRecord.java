/*
 * This file is generated by jOOQ.
 */
package com.epam.ta.reportportal.jooq.tables.records;


import com.epam.ta.reportportal.jooq.tables.JRecipients;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JRecipientsRecord extends TableRecordImpl<JRecipientsRecord> implements Record2<Long, String> {

    private static final long serialVersionUID = 783073081;

    /**
     * Setter for <code>public.recipients.sender_case_id</code>.
     */
    public void setSenderCaseId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.recipients.sender_case_id</code>.
     */
    public Long getSenderCaseId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.recipients.recipient</code>.
     */
    public void setRecipient(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.recipients.recipient</code>.
     */
    public String getRecipient() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Long, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Long, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return JRecipients.RECIPIENTS.SENDER_CASE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return JRecipients.RECIPIENTS.RECIPIENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getSenderCaseId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getRecipient();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getSenderCaseId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getRecipient();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JRecipientsRecord value1(Long value) {
        setSenderCaseId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JRecipientsRecord value2(String value) {
        setRecipient(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JRecipientsRecord values(Long value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached JRecipientsRecord
     */
    public JRecipientsRecord() {
        super(JRecipients.RECIPIENTS);
    }

    /**
     * Create a detached, initialised JRecipientsRecord
     */
    public JRecipientsRecord(Long senderCaseId, String recipient) {
        super(JRecipients.RECIPIENTS);

        set(0, senderCaseId);
        set(1, recipient);
    }
}
