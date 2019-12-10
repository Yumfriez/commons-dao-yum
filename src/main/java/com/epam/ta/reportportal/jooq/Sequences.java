/*
 * This file is generated by jOOQ.
 */
package com.epam.ta.reportportal.jooq;


import javax.annotation.processing.Generated;

import org.jooq.Sequence;
import org.jooq.impl.SequenceImpl;


/**
 * Convenience access to all sequences in public
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

    /**
     * The sequence <code>public.acl_class_id_seq</code>
     */
    public static final Sequence<Long> ACL_CLASS_ID_SEQ = new SequenceImpl<Long>("acl_class_id_seq", JPublic.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.acl_entry_id_seq</code>
     */
    public static final Sequence<Long> ACL_ENTRY_ID_SEQ = new SequenceImpl<Long>("acl_entry_id_seq", JPublic.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.acl_object_identity_id_seq</code>
     */
    public static final Sequence<Long> ACL_OBJECT_IDENTITY_ID_SEQ = new SequenceImpl<Long>("acl_object_identity_id_seq", JPublic.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.acl_sid_id_seq</code>
     */
    public static final Sequence<Long> ACL_SID_ID_SEQ = new SequenceImpl<Long>("acl_sid_id_seq", JPublic.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.activity_id_seq</code>
     */
    public static final Sequence<Long> ACTIVITY_ID_SEQ = new SequenceImpl<Long>("activity_id_seq", JPublic.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.attachment_id_seq</code>
     */
    public static final Sequence<Long> ATTACHMENT_ID_SEQ = new SequenceImpl<Long>("attachment_id_seq", JPublic.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.attribute_id_seq</code>
     */
    public static final Sequence<Long> ATTRIBUTE_ID_SEQ = new SequenceImpl<Long>("attribute_id_seq", JPublic.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.filter_condition_id_seq</code>
     */
    public static final Sequence<Long> FILTER_CONDITION_ID_SEQ = new SequenceImpl<Long>("filter_condition_id_seq", JPublic.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.filter_sort_id_seq</code>
     */
    public static final Sequence<Long> FILTER_SORT_ID_SEQ = new SequenceImpl<Long>("filter_sort_id_seq", JPublic.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.integration_id_seq</code>
     */
    public static final Sequence<Integer> INTEGRATION_ID_SEQ = new SequenceImpl<Integer>("integration_id_seq", JPublic.PUBLIC, org.jooq.impl.SQLDataType.INTEGER.nullable(false));

    /**
     * The sequence <code>public.integration_type_id_seq</code>
     */
    public static final Sequence<Integer> INTEGRATION_TYPE_ID_SEQ = new SequenceImpl<Integer>("integration_type_id_seq", JPublic.PUBLIC, org.jooq.impl.SQLDataType.INTEGER.nullable(false));

    /**
     * The sequence <code>public.issue_group_issue_group_id_seq</code>
     */
    public static final Sequence<Short> ISSUE_GROUP_ISSUE_GROUP_ID_SEQ = new SequenceImpl<Short>("issue_group_issue_group_id_seq", JPublic.PUBLIC, org.jooq.impl.SQLDataType.SMALLINT.nullable(false));

    /**
     * The sequence <code>public.issue_type_id_seq</code>
     */
    public static final Sequence<Long> ISSUE_TYPE_ID_SEQ = new SequenceImpl<Long>("issue_type_id_seq", JPublic.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.item_attribute_id_seq</code>
     */
    public static final Sequence<Long> ITEM_ATTRIBUTE_ID_SEQ = new SequenceImpl<Long>("item_attribute_id_seq", JPublic.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.launch_attribute_rules_id_seq</code>
     */
    public static final Sequence<Long> LAUNCH_ATTRIBUTE_RULES_ID_SEQ = new SequenceImpl<Long>("launch_attribute_rules_id_seq", JPublic.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.launch_id_seq</code>
     */
    public static final Sequence<Long> LAUNCH_ID_SEQ = new SequenceImpl<Long>("launch_id_seq", JPublic.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.launch_number_id_seq</code>
     */
    public static final Sequence<Long> LAUNCH_NUMBER_ID_SEQ = new SequenceImpl<Long>("launch_number_id_seq", JPublic.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.log_id_seq</code>
     */
    public static final Sequence<Long> LOG_ID_SEQ = new SequenceImpl<Long>("log_id_seq", JPublic.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.oauth_access_token_id_seq</code>
     */
    public static final Sequence<Long> OAUTH_ACCESS_TOKEN_ID_SEQ = new SequenceImpl<Long>("oauth_access_token_id_seq", JPublic.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.oauth_registration_restriction_id_seq</code>
     */
    public static final Sequence<Integer> OAUTH_REGISTRATION_RESTRICTION_ID_SEQ = new SequenceImpl<Integer>("oauth_registration_restriction_id_seq", JPublic.PUBLIC, org.jooq.impl.SQLDataType.INTEGER.nullable(false));

    /**
     * The sequence <code>public.oauth_registration_scope_id_seq</code>
     */
    public static final Sequence<Integer> OAUTH_REGISTRATION_SCOPE_ID_SEQ = new SequenceImpl<Integer>("oauth_registration_scope_id_seq", JPublic.PUBLIC, org.jooq.impl.SQLDataType.INTEGER.nullable(false));

    /**
     * The sequence <code>public.pattern_template_id_seq</code>
     */
    public static final Sequence<Long> PATTERN_TEMPLATE_ID_SEQ = new SequenceImpl<Long>("pattern_template_id_seq", JPublic.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.project_attribute_attribute_id_seq</code>
     */
    public static final Sequence<Long> PROJECT_ATTRIBUTE_ATTRIBUTE_ID_SEQ = new SequenceImpl<Long>("project_attribute_attribute_id_seq", JPublic.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.project_attribute_project_id_seq</code>
     */
    public static final Sequence<Long> PROJECT_ATTRIBUTE_PROJECT_ID_SEQ = new SequenceImpl<Long>("project_attribute_project_id_seq", JPublic.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.project_id_seq</code>
     */
    public static final Sequence<Long> PROJECT_ID_SEQ = new SequenceImpl<Long>("project_id_seq", JPublic.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.sender_case_id_seq</code>
     */
    public static final Sequence<Long> SENDER_CASE_ID_SEQ = new SequenceImpl<Long>("sender_case_id_seq", JPublic.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.sender_case_project_id_seq</code>
     */
    public static final Sequence<Long> SENDER_CASE_PROJECT_ID_SEQ = new SequenceImpl<Long>("sender_case_project_id_seq", JPublic.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.server_settings_id_seq</code>
     */
    public static final Sequence<Short> SERVER_SETTINGS_ID_SEQ = new SequenceImpl<Short>("server_settings_id_seq", JPublic.PUBLIC, org.jooq.impl.SQLDataType.SMALLINT.nullable(false));

    /**
     * The sequence <code>public.shareable_entity_id_seq</code>
     */
    public static final Sequence<Long> SHAREABLE_ENTITY_ID_SEQ = new SequenceImpl<Long>("shareable_entity_id_seq", JPublic.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.statistics_field_sf_id_seq</code>
     */
    public static final Sequence<Long> STATISTICS_FIELD_SF_ID_SEQ = new SequenceImpl<Long>("statistics_field_sf_id_seq", JPublic.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.statistics_s_id_seq</code>
     */
    public static final Sequence<Long> STATISTICS_S_ID_SEQ = new SequenceImpl<Long>("statistics_s_id_seq", JPublic.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.test_item_item_id_seq</code>
     */
    public static final Sequence<Long> TEST_ITEM_ITEM_ID_SEQ = new SequenceImpl<Long>("test_item_item_id_seq", JPublic.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.ticket_id_seq</code>
     */
    public static final Sequence<Long> TICKET_ID_SEQ = new SequenceImpl<Long>("ticket_id_seq", JPublic.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.user_preference_id_seq</code>
     */
    public static final Sequence<Long> USER_PREFERENCE_ID_SEQ = new SequenceImpl<Long>("user_preference_id_seq", JPublic.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

    /**
     * The sequence <code>public.users_id_seq</code>
     */
    public static final Sequence<Long> USERS_ID_SEQ = new SequenceImpl<Long>("users_id_seq", JPublic.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));
}
