/*
 * This file is generated by jOOQ.
 */
package com.epam.ta.reportportal.jooq.tables.records;


import com.epam.ta.reportportal.jooq.tables.JLog;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;


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
public class JLogRecord extends UpdatableRecordImpl<JLogRecord> implements Record9<Long, String, Timestamp, String, Long, Long, Timestamp, Integer, Long> {

    private static final long serialVersionUID = -1798939929;

    /**
     * Setter for <code>public.log.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.log.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.log.uuid</code>.
     */
    public void setUuid(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.log.uuid</code>.
     */
    public String getUuid() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.log.log_time</code>.
     */
    public void setLogTime(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.log.log_time</code>.
     */
    public Timestamp getLogTime() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>public.log.log_message</code>.
     */
    public void setLogMessage(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.log.log_message</code>.
     */
    public String getLogMessage() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.log.item_id</code>.
     */
    public void setItemId(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.log.item_id</code>.
     */
    public Long getItemId() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>public.log.launch_id</code>.
     */
    public void setLaunchId(Long value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.log.launch_id</code>.
     */
    public Long getLaunchId() {
        return (Long) get(5);
    }

    /**
     * Setter for <code>public.log.last_modified</code>.
     */
    public void setLastModified(Timestamp value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.log.last_modified</code>.
     */
    public Timestamp getLastModified() {
        return (Timestamp) get(6);
    }

    /**
     * Setter for <code>public.log.log_level</code>.
     */
    public void setLogLevel(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.log.log_level</code>.
     */
    public Integer getLogLevel() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>public.log.attachment_id</code>.
     */
    public void setAttachmentId(Long value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.log.attachment_id</code>.
     */
    public Long getAttachmentId() {
        return (Long) get(8);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<Long, String, Timestamp, String, Long, Long, Timestamp, Integer, Long> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<Long, String, Timestamp, String, Long, Long, Timestamp, Integer, Long> valuesRow() {
        return (Row9) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return JLog.LOG.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return JLog.LOG.UUID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field3() {
        return JLog.LOG.LOG_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return JLog.LOG.LOG_MESSAGE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field5() {
        return JLog.LOG.ITEM_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field6() {
        return JLog.LOG.LAUNCH_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field7() {
        return JLog.LOG.LAST_MODIFIED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field8() {
        return JLog.LOG.LOG_LEVEL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field9() {
        return JLog.LOG.ATTACHMENT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getUuid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component3() {
        return getLogTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getLogMessage();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component5() {
        return getItemId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component6() {
        return getLaunchId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component7() {
        return getLastModified();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component8() {
        return getLogLevel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component9() {
        return getAttachmentId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getUuid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value3() {
        return getLogTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getLogMessage();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value5() {
        return getItemId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value6() {
        return getLaunchId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value7() {
        return getLastModified();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value8() {
        return getLogLevel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value9() {
        return getAttachmentId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JLogRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JLogRecord value2(String value) {
        setUuid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JLogRecord value3(Timestamp value) {
        setLogTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JLogRecord value4(String value) {
        setLogMessage(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JLogRecord value5(Long value) {
        setItemId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JLogRecord value6(Long value) {
        setLaunchId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JLogRecord value7(Timestamp value) {
        setLastModified(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JLogRecord value8(Integer value) {
        setLogLevel(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JLogRecord value9(Long value) {
        setAttachmentId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JLogRecord values(Long value1, String value2, Timestamp value3, String value4, Long value5, Long value6, Timestamp value7, Integer value8, Long value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached JLogRecord
     */
    public JLogRecord() {
        super(JLog.LOG);
    }

    /**
     * Create a detached, initialised JLogRecord
     */
    public JLogRecord(Long id, String uuid, Timestamp logTime, String logMessage, Long itemId, Long launchId, Timestamp lastModified, Integer logLevel, Long attachmentId) {
        super(JLog.LOG);

        set(0, id);
        set(1, uuid);
        set(2, logTime);
        set(3, logMessage);
        set(4, itemId);
        set(5, launchId);
        set(6, lastModified);
        set(7, logLevel);
        set(8, attachmentId);
    }
}
