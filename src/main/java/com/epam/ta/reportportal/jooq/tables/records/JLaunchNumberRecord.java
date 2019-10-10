/*
 * Copyright 2019 EPAM Systems
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
package com.epam.ta.reportportal.jooq.tables.records;

import com.epam.ta.reportportal.jooq.tables.JLaunchNumber;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;

import javax.annotation.Generated;

/**
 * This class is generated by jOOQ.
 */
@Generated(value = { "http://www.jooq.org", "jOOQ version:3.11.11" }, comments = "This class is generated by jOOQ")
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JLaunchNumberRecord extends UpdatableRecordImpl<JLaunchNumberRecord> implements Record4<Long, Long, String, Integer> {

	private static final long serialVersionUID = 1276602168;

	/**
	 * Setter for <code>public.launch_number.id</code>.
	 */
	public void setId(Long value) {
		set(0, value);
	}

	/**
	 * Getter for <code>public.launch_number.id</code>.
	 */
	public Long getId() {
		return (Long) get(0);
	}

	/**
	 * Setter for <code>public.launch_number.project_id</code>.
	 */
	public void setProjectId(Long value) {
		set(1, value);
	}

	/**
	 * Getter for <code>public.launch_number.project_id</code>.
	 */
	public Long getProjectId() {
		return (Long) get(1);
	}

	/**
	 * Setter for <code>public.launch_number.launch_name</code>.
	 */
	public void setLaunchName(String value) {
		set(2, value);
	}

	/**
	 * Getter for <code>public.launch_number.launch_name</code>.
	 */
	public String getLaunchName() {
		return (String) get(2);
	}

	/**
	 * Setter for <code>public.launch_number.number</code>.
	 */
	public void setNumber(Integer value) {
		set(3, value);
	}

	/**
	 * Getter for <code>public.launch_number.number</code>.
	 */
	public Integer getNumber() {
		return (Integer) get(3);
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
	// Record4 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row4<Long, Long, String, Integer> fieldsRow() {
		return (Row4) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row4<Long, Long, String, Integer> valuesRow() {
		return (Row4) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Long> field1() {
		return JLaunchNumber.LAUNCH_NUMBER.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Long> field2() {
		return JLaunchNumber.LAUNCH_NUMBER.PROJECT_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field3() {
		return JLaunchNumber.LAUNCH_NUMBER.LAUNCH_NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field4() {
		return JLaunchNumber.LAUNCH_NUMBER.NUMBER;
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
	public Long component2() {
		return getProjectId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String component3() {
		return getLaunchName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer component4() {
		return getNumber();
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
	public Long value2() {
		return getProjectId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value3() {
		return getLaunchName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value4() {
		return getNumber();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JLaunchNumberRecord value1(Long value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JLaunchNumberRecord value2(Long value) {
		setProjectId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JLaunchNumberRecord value3(String value) {
		setLaunchName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JLaunchNumberRecord value4(Integer value) {
		setNumber(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JLaunchNumberRecord values(Long value1, Long value2, String value3, Integer value4) {
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
	 * Create a detached JLaunchNumberRecord
	 */
	public JLaunchNumberRecord() {
		super(JLaunchNumber.LAUNCH_NUMBER);
	}

	/**
	 * Create a detached, initialised JLaunchNumberRecord
	 */
	public JLaunchNumberRecord(Long id, Long projectId, String launchName, Integer number) {
		super(JLaunchNumber.LAUNCH_NUMBER);

		set(0, id);
		set(1, projectId);
		set(2, launchName);
		set(3, number);
	}
}
