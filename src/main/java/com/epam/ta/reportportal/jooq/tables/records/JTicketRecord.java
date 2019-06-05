/*
 * This file is generated by jOOQ.
 */
package com.epam.ta.reportportal.jooq.tables.records;

import com.epam.ta.reportportal.jooq.tables.JTicket;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;

import javax.annotation.Generated;
import java.sql.Timestamp;


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
public class JTicketRecord extends UpdatableRecordImpl<JTicketRecord> implements Record7<Long, String, Long, Timestamp, String, String, String> {

    private static final long serialVersionUID = 1290738211;

    /**
     * Setter for <code>public.ticket.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.ticket.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.ticket.ticket_id</code>.
     */
    public void setTicketId(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.ticket.ticket_id</code>.
     */
    public String getTicketId() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.ticket.submitter_id</code>.
     */
    public void setSubmitterId(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.ticket.submitter_id</code>.
     */
    public Long getSubmitterId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>public.ticket.submit_date</code>.
     */
    public void setSubmitDate(Timestamp value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.ticket.submit_date</code>.
     */
    public Timestamp getSubmitDate() {
        return (Timestamp) get(3);
    }

    /**
     * Setter for <code>public.ticket.bts_url</code>.
     */
    public void setBtsUrl(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.ticket.bts_url</code>.
     */
    public String getBtsUrl() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.ticket.bts_project</code>.
     */
    public void setBtsProject(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.ticket.bts_project</code>.
     */
    public String getBtsProject() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.ticket.url</code>.
     */
    public void setUrl(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.ticket.url</code>.
     */
    public String getUrl() {
        return (String) get(6);
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
    // Record7 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Long, String, Long, Timestamp, String, String, String> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Long, String, Long, Timestamp, String, String, String> valuesRow() {
        return (Row7) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return JTicket.TICKET.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return JTicket.TICKET.TICKET_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field3() {
        return JTicket.TICKET.SUBMITTER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field4() {
        return JTicket.TICKET.SUBMIT_DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return JTicket.TICKET.BTS_URL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return JTicket.TICKET.BTS_PROJECT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return JTicket.TICKET.URL;
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
        return getTicketId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component3() {
        return getSubmitterId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component4() {
        return getSubmitDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getBtsUrl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getBtsProject();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getUrl();
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
        return getTicketId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value3() {
        return getSubmitterId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value4() {
        return getSubmitDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getBtsUrl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getBtsProject();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getUrl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JTicketRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JTicketRecord value2(String value) {
        setTicketId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JTicketRecord value3(Long value) {
        setSubmitterId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JTicketRecord value4(Timestamp value) {
        setSubmitDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JTicketRecord value5(String value) {
        setBtsUrl(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JTicketRecord value6(String value) {
        setBtsProject(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JTicketRecord value7(String value) {
        setUrl(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JTicketRecord values(Long value1, String value2, Long value3, Timestamp value4, String value5, String value6, String value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached JTicketRecord
     */
    public JTicketRecord() {
        super(JTicket.TICKET);
    }

    /**
     * Create a detached, initialised JTicketRecord
     */
    public JTicketRecord(Long id, String ticketId, Long submitterId, Timestamp submitDate, String btsUrl, String btsProject, String url) {
        super(JTicket.TICKET);

        set(0, id);
        set(1, ticketId);
        set(2, submitterId);
        set(3, submitDate);
        set(4, btsUrl);
        set(5, btsProject);
        set(6, url);
    }
}
