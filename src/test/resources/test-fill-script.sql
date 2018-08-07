INSERT INTO project (name, additional_info, creation_date) VALUES ('default_personal', 'additional info', '2018-07-19 13:25:00');
INSERT INTO project_configuration (id, project_type, interrupt_timeout, keep_logs_interval, keep_screenshots_interval, created_on)
VALUES ((SELECT currval(pg_get_serial_sequence('project', 'id'))), 'PERSONAL', '1 day', '1 month', '2 weeks', '2018-07-19 13:25:00');

INSERT INTO users (login, password, email, role, type, default_project_id, full_name, expired)
VALUES ('default', '3fde6bb0541387e4ebdadf7c2ff31123', 'defaultemail@domain.com', 'USER', 'INTERNAL',
        (SELECT currval(pg_get_serial_sequence('project', 'id'))), 'tester', false);

INSERT INTO project_user (user_id, project_id, project_role)
VALUES ((SELECT currval(pg_get_serial_sequence('users', 'id'))), (SELECT currval(pg_get_serial_sequence('project', 'id'))), 'MEMBER');

INSERT INTO project (name, additional_info, creation_date) VALUES ('superadmin_personal', 'another additional info', '2018-07-19 14:25:00');
INSERT INTO project_configuration (id, project_type, interrupt_timeout, keep_logs_interval, keep_screenshots_interval, created_on)
VALUES ((SELECT currval(pg_get_serial_sequence('project', 'id'))), 'PERSONAL', '1 day', '1 month', '2 weeks', '2018-07-19 14:25:00');

INSERT INTO users (login, password, email, role, type, default_project_id, full_name, expired)
VALUES ('superadmin', '5d39d85bddde885f6579f8121e11eba2', 'superadminemail@domain.com', 'ADMINISTRATOR', 'INTERNAL',
        (SELECT currval(pg_get_serial_sequence('project', 'id'))), 'tester', false);

INSERT INTO project_user (user_id, project_id, project_role) VALUES
  ((SELECT currval(pg_get_serial_sequence('users', 'id'))), (SELECT currval(pg_get_serial_sequence('project', 'id'))), 'PROJECT_MANAGER');

INSERT INTO integration_type(
	name, auth_flow, creation_date, group_type)
	VALUES ('test integration type', 'LDAP', '2018-07-19 13:25:00', 'NOTIFICATION');

INSERT INTO integration(
	project_id, type, enabled, creation_date)
	VALUES ((SELECT currval(pg_get_serial_sequence('project', 'id'))), (SELECT currval(pg_get_serial_sequence('integration_type', 'id'))), true, '2018-07-19 13:25:00');

INSERT INTO ldap_synchronization_attributes(
	email, full_name, photo)
	VALUES ('mail', 'displayName', 'thumbnailPhoto');

INSERT INTO public.filter (id, name, project_id, target, description) VALUES (1, 'launch name', 1, 'com.epam.ta.reportportal.entity.launch.Launch', null);
INSERT INTO public.filter (id, name, project_id, target, description) VALUES (2, 'launch_name_filter', 1, 'com.epam.ta.reportportal.entity.Activity', null);

INSERT INTO public.user_filter(id) VALUES (1);
INSERT INTO public.user_filter(id) VALUES (2);

INSERT INTO public.filter_condition (id, filter_id, condition, value, field, negative) VALUES (8, 1, 'NOT_EQUALS', 'IN_PROGRESS', 'status', false);
INSERT INTO public.filter_condition (id, filter_id, condition, value, field, negative) VALUES (7, 1, 'EQUALS', 'DEFAULT', 'mode', false);
INSERT INTO public.filter_condition (id, filter_id, condition, value, field, negative) VALUES (6, 1, 'EQUALS', '1', 'project_id', false);
INSERT INTO public.filter_condition (id, filter_id, condition, value, field, negative) VALUES (10, 2, 'EQUALS', '1', 'project_id', false);

INSERT INTO public.widget (id, name, description, widget_type, items_count, project_id, filter_id) VALUES (2, 'start', null, 'launch_statistics', 1000, 1, 1);
INSERT INTO public.widget (id, name, description, widget_type, items_count, project_id, filter_id) VALUES (4, 'start', null, 'passing_rate_per_launch', 1000, 1, 1);
INSERT INTO public.widget (id, name, description, widget_type, items_count, project_id, filter_id) VALUES (5, 'start', null, 'passing_rate_summary', 1000, 1, 1);
INSERT INTO public.widget (id, name, description, widget_type, items_count, project_id, filter_id) VALUES (6, 'start', null, 'cases_trend', 1000, 1, 1);
INSERT INTO public.widget (id, name, description, widget_type, items_count, project_id, filter_id) VALUES (7, 'my widget', null, 'bug_trend', 1000, 1, 1);
INSERT INTO public.widget (id, name, description, widget_type, items_count, project_id, filter_id) VALUES (3, 'start', null, 'investigated_trend', 1000, 1, 1);
INSERT INTO public.widget (id, name, description, widget_type, items_count, project_id, filter_id) VALUES (12, 'table', null, 'launches_table', 1000, 1, 1);
INSERT INTO public.widget (id, name, description, widget_type, items_count, project_id, filter_id) VALUES (8, 'comparison', null, 'launches_comparison_chart', 1000, 1, 1);
INSERT INTO public.widget (id, name, description, widget_type, items_count, project_id, filter_id) VALUES (9, 'duration', null, 'launches_duration_chart', 1000, 1, 1);
INSERT INTO public.widget (id, name, description, widget_type, items_count, project_id, filter_id) VALUES (10, 'not passed', null, 'not_passed', 1000, 1, 1);
INSERT INTO public.widget (id, name, description, widget_type, items_count, project_id, filter_id) VALUES (11, 'not passed', null, 'most_failed_test_cases', 1000, 1, 1);
INSERT INTO public.widget (id, name, description, widget_type, items_count, project_id, filter_id) VALUES (17, 'table', null, 'activity_stream', 1000, 1, 2);
INSERT INTO public.widget (id, name, description, widget_type, items_count, project_id, filter_id) VALUES (1, 'start', null, 'overall_statistics', 1000, 1, 1);
INSERT INTO public.widget (id, name, description, widget_type, items_count, project_id, filter_id) VALUES (18, 'unique', null, 'unique_bug_table', 1000, 1, 2);

INSERT INTO public.widget_option (id, widget_id, option) VALUES (1, 1, 'filterName');
INSERT INTO public.widget_option (id, widget_id, option) VALUES (2, 2, 'filterName');
INSERT INTO public.widget_option (id, widget_id, option) VALUES (3, 3, 'filterName');
INSERT INTO public.widget_option (id, widget_id, option) VALUES (5, 5, 'filterName');
INSERT INTO public.widget_option (id, widget_id, option) VALUES (6, 6, 'filterName');
INSERT INTO public.widget_option (id, widget_id, option) VALUES (7, 7, 'filterName');
INSERT INTO public.widget_option (id, widget_id, option) VALUES (9, 9, 'filterName');
INSERT INTO public.widget_option (id, widget_id, option) VALUES (10, 10, 'filterName');
INSERT INTO public.widget_option (id, widget_id, option) VALUES (11, 11, 'launch_name_filter');
INSERT INTO public.widget_option (id, widget_id, option) VALUES (12, 12, 'filterName');
INSERT INTO public.widget_option (id, widget_id, option) VALUES (8, 8, 'launch_name_filter');
INSERT INTO public.widget_option (id, widget_id, option) VALUES (4, 4, 'launch_name_filter');
INSERT INTO public.widget_option (id, widget_id, option) VALUES (17, 17, 'login');
INSERT INTO public.widget_option (id, widget_id, option) VALUES (18, 17, 'activity_type');

INSERT INTO public.widget_option_value (id, value) VALUES (1, 'New_filter');
INSERT INTO public.widget_option_value (id, value) VALUES (2, 'New_filter');
INSERT INTO public.widget_option_value (id, value) VALUES (3, 'New_filter');
INSERT INTO public.widget_option_value (id, value) VALUES (4, 'launch name');
INSERT INTO public.widget_option_value (id, value) VALUES (5, 'New filter');
INSERT INTO public.widget_option_value (id, value) VALUES (6, 'New filter');
INSERT INTO public.widget_option_value (id, value) VALUES (7, 'New filter');
INSERT INTO public.widget_option_value (id, value) VALUES (8, 'launch name');
INSERT INTO public.widget_option_value (id, value) VALUES (9, 'New filter');
INSERT INTO public.widget_option_value (id, value) VALUES (10, 'New filter');
INSERT INTO public.widget_option_value (id, value) VALUES (11, 'launch name');
INSERT INTO public.widget_option_value (id, value) VALUES (12, 'New filter');
INSERT INTO public.widget_option_value (id, value) VALUES (17, 'default');
INSERT INTO public.widget_option_value (id, value) VALUES (18, 'CREATE_ITEM');
INSERT INTO public.widget_option_value (id, value) VALUES (18, 'UPDATE_LAUNCH');

INSERT INTO public.content_field (id, widget_id, field) VALUES (1, 2, 'executions');
INSERT INTO public.content_field (id, widget_id, field) VALUES (2, 2, 'defects');
INSERT INTO public.content_field (id, widget_id, field) VALUES (3, 4, 'executions');
INSERT INTO public.content_field (id, widget_id, field) VALUES (4, 5, 'executions');
INSERT INTO public.content_field (id, widget_id, field) VALUES (5, 6, 'executions');
INSERT INTO public.content_field (id, widget_id, field) VALUES (6, 7, 'defects');
INSERT INTO public.content_field (id, widget_id, field) VALUES (8, 8, 'executions');
INSERT INTO public.content_field (id, widget_id, field) VALUES (9, 9, 'executions');
INSERT INTO public.content_field (id, widget_id, field) VALUES (10, 10, 'executions');
INSERT INTO public.content_field (id, widget_id, field) VALUES (11, 12, 'executions');
INSERT INTO public.content_field (id, widget_id, field) VALUES (12, 12, 'defects');
INSERT INTO public.content_field (id, widget_id, field) VALUES (7, 8, 'groups');
INSERT INTO public.content_field (id, widget_id, field) VALUES (13, 12, 'columns');

INSERT INTO public.content_field_value (id, value) VALUES (1, 'FAILED');
INSERT INTO public.content_field_value (id, value) VALUES (1, 'SKIPPED');
INSERT INTO public.content_field_value (id, value) VALUES (1, 'PASSED');
INSERT INTO public.content_field_value (id, value) VALUES (2, 'AB001');
INSERT INTO public.content_field_value (id, value) VALUES (2, 'AB002');
INSERT INTO public.content_field_value (id, value) VALUES (2, 'SI001');
INSERT INTO public.content_field_value (id, value) VALUES (2, 'TI001');
INSERT INTO public.content_field_value (id, value) VALUES (2, 'PB001');
INSERT INTO public.content_field_value (id, value) VALUES (2, 'ND001');
INSERT INTO public.content_field_value (id, value) VALUES (3, 'FAILED');
INSERT INTO public.content_field_value (id, value) VALUES (3, 'SKIPPED');
INSERT INTO public.content_field_value (id, value) VALUES (4, 'FAILED');
INSERT INTO public.content_field_value (id, value) VALUES (4, 'SKIPPED');
INSERT INTO public.content_field_value (id, value) VALUES (4, 'PASSED');
INSERT INTO public.content_field_value (id, value) VALUES (5, 'FAILED');
INSERT INTO public.content_field_value (id, value) VALUES (5, 'SKIPPED');
INSERT INTO public.content_field_value (id, value) VALUES (5, 'PASSED');
INSERT INTO public.content_field_value (id, value) VALUES (6, 'AB001');
INSERT INTO public.content_field_value (id, value) VALUES (6, 'PB001');
INSERT INTO public.content_field_value (id, value) VALUES (6, 'SI001');
INSERT INTO public.content_field_value (id, value) VALUES (8, 'FAILED');
INSERT INTO public.content_field_value (id, value) VALUES (8, 'SKIPPED');
INSERT INTO public.content_field_value (id, value) VALUES (8, 'PASSED');
INSERT INTO public.content_field_value (id, value) VALUES (9, 'FAILED');
INSERT INTO public.content_field_value (id, value) VALUES (9, 'SKIPPED');
INSERT INTO public.content_field_value (id, value) VALUES (9, 'PASSED');
INSERT INTO public.content_field_value (id, value) VALUES (10, 'FAILED');
INSERT INTO public.content_field_value (id, value) VALUES (10, 'SKIPPED');
INSERT INTO public.content_field_value (id, value) VALUES (10, 'PASSED');
INSERT INTO public.content_field_value (id, value) VALUES (11, 'FAILED');
INSERT INTO public.content_field_value (id, value) VALUES (11, 'SKIPPED');
INSERT INTO public.content_field_value (id, value) VALUES (11, 'PASSED');
INSERT INTO public.content_field_value (id, value) VALUES (12, 'AB001');
INSERT INTO public.content_field_value (id, value) VALUES (12, 'AB002');
INSERT INTO public.content_field_value (id, value) VALUES (12, 'PB001');
INSERT INTO public.content_field_value (id, value) VALUES (12, 'TI001');
INSERT INTO public.content_field_value (id, value) VALUES (12, 'ND001');
INSERT INTO public.content_field_value (id, value) VALUES (12, 'SI001');
INSERT INTO public.content_field_value (id, value) VALUES (3, 'PASSED');
INSERT INTO public.content_field_value (id, value) VALUES (7, 'AUTOMATION_BUG');
INSERT INTO public.content_field_value (id, value) VALUES (7, 'SYSTEM_ISSUE');
INSERT INTO public.content_field_value (id, value) VALUES (7, 'NO_DEFECT');
INSERT INTO public.content_field_value (id, value) VALUES (7, 'TO_INVESTIGATE');
INSERT INTO public.content_field_value (id, value) VALUES (7, 'PRODUCT_BUG');
INSERT INTO public.content_field_value (id, value) VALUES (13, 'number');
INSERT INTO public.content_field_value (id, value) VALUES (13, 'last_modified');
INSERT INTO public.content_field_value (id, value) VALUES (6, 'ND001');