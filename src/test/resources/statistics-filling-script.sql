INSERT INTO public.launch (id, uuid, project_id, user_id, name, description, start_time, end_time, last_modified, mode, status) VALUES (1, 'asdqwerty123', 1, 1, 'test launch', 'descr', '2018-11-05 08:51:21.305000', '2018-11-05 08:51:23.306000', '2018-11-05 08:51:34.411347', 'DEFAULT', 'FAILED');
INSERT INTO public.launch (id, uuid, project_id, user_id, name, description, start_time, end_time, last_modified, mode, status) VALUES (1, 'asdqwerty1232', 1, 1, 'test launch', 'descr', '2018-11-05 08:51:21.305000', '2018-11-05 08:51:23.306000', '2018-11-05 08:51:34.411347', 'DEFAULT', 'FAILED');
INSERT INTO public.launch (id, uuid, project_id, user_id, name, description, start_time, end_time, last_modified, mode, status) VALUES (1, 'asdqwerty1233', 1, 1, 'test launch', 'descr', '2018-11-05 08:51:21.305000', '2018-11-05 08:51:23.306000', '2018-11-05 08:51:34.411347', 'DEFAULT', 'FAILED');
INSERT INTO public.launch (id, uuid, project_id, user_id, name, description, start_time, end_time, last_modified, mode, status) VALUES (1, 'jjjjjjqwerty', 1, 1, 'launch name test', 'descr', '2018-11-05 08:51:21.305000', '2018-11-05 08:51:23.306000', '2018-11-05 08:51:34.411347', 'DEFAULT', 'FAILED');

INSERT INTO statistics_field (sf_id, name) VALUES (1, 'statistics$executions$total');
INSERT INTO statistics_field (sf_id, name) VALUES (2, 'statistics$executions$passed');
INSERT INTO statistics_field (sf_id, name) VALUES (3, 'statistics$executions$skipped');
INSERT INTO statistics_field (sf_id, name) VALUES (4, 'statistics$executions$failed');
INSERT INTO statistics_field (sf_id, name) VALUES (5, 'statistics$defects$to_investigate$total');
INSERT INTO statistics_field (sf_id, name) VALUES (6, 'statistics$defects$system_issue$total');
INSERT INTO statistics_field (sf_id, name) VALUES (7, 'statistics$defects$automation_bug$total');
INSERT INTO statistics_field (sf_id, name) VALUES (8, 'statistics$defects$product_bug$total');
INSERT INTO statistics_field (sf_id, name) VALUES (9, 'statistics$defects$no_defect$total');
INSERT INTO statistics_field (sf_id, name) VALUES (10, 'statistics$defects$to_investigate$TI001');
INSERT INTO statistics_field (sf_id, name) VALUES (11, 'statistics$defects$system_issue$SI001');
INSERT INTO statistics_field (sf_id, name) VALUES (12, 'statistics$defects$automation_bug$AB001');
INSERT INTO statistics_field (sf_id, name) VALUES (13, 'statistics$defects$product_bug$PB001');
INSERT INTO statistics_field (sf_id, name) VALUES (14, 'statistics$defects$no_defect$ND001');

-------------------------------------------------------------------------------------------------------------------<
-------------------------------------------------------------------------------------------------------------------<
-- LAUNCHES STATISTICS
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(1, 1, 10);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(1, 2, 3);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(1, 3, 4);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(1, 4, 3);

INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(1, 5, 2);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(1, 6, 8);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(1, 7, 7);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(1, 8, 13);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(1, 9, 2);

INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(1, 10, 2);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(1, 11, 8);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(1, 12, 7);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(1, 13, 13);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(1, 14, 2);

--

INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(2, 1, 11);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(2, 2, 2);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(2, 3, 3);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(2, 4, 6);

INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(2, 5, 3);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(2, 6, 3);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(2, 7, 1);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(2, 8, 1);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(2, 9, 2);

INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(2, 10, 3);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(2, 11, 3);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(2, 12, 1);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(2, 13, 1);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(2, 14, 2);

--

INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(3, 1, 15);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(3, 2, 5);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(3, 3, 5);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(3, 4, 5);

INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(3, 5, 1);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(3, 6, 1);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(3, 7, 1);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(3, 8, 1);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(3, 9, 1);

INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(3, 10, 1);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(3, 11, 1);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(3, 12, 1);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(3, 13, 1);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(3, 14, 1);

--

INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(4, 1, 12);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(4, 2, 3);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(4, 3, 1);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(4, 4, 8);

INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(4, 5, 3);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(4, 6, 4);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(4, 7, 2);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(4, 8, 2);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(4, 9, 6);

INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(4, 10, 3);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(4, 11, 4);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(4, 12, 2);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(4, 13, 2);
INSERT INTO statistics(launch_id, statistics_field_id, s_counter) VALUES(4, 14, 6);
------------------------------------------------------------------------------------------------------------------->


-------------------------------------------------------------------------------------------------------------------<
-------------------------------------------------------------------------------------------------------------------<
-- TEST ITEMS STATISTICS
INSERT INTO statistics(item_id, statistics_field_id, s_counter) VALUES(614, 2, 3);
INSERT INTO statistics(item_id, statistics_field_id, s_counter) VALUES(614, 4, 3);
INSERT INTO statistics(item_id, statistics_field_id, s_counter) VALUES(615, 2, 3);
INSERT INTO statistics(item_id, statistics_field_id, s_counter) VALUES(615, 4, 3);
INSERT INTO statistics(item_id, statistics_field_id, s_counter) VALUES(616, 2, 3);
INSERT INTO statistics(item_id, statistics_field_id, s_counter) VALUES(616, 4, 3);
INSERT INTO statistics(item_id, statistics_field_id, s_counter) VALUES(617, 2, 3);
INSERT INTO statistics(item_id, statistics_field_id, s_counter) VALUES(617, 4, 3);
INSERT INTO statistics(item_id, statistics_field_id, s_counter) VALUES(618, 2, 3);
INSERT INTO statistics(item_id, statistics_field_id, s_counter) VALUES(618, 4, 3);
INSERT INTO statistics(item_id, statistics_field_id, s_counter) VALUES(619, 2, 3);
INSERT INTO statistics(item_id, statistics_field_id, s_counter) VALUES(619, 4, 3);
INSERT INTO statistics(item_id, statistics_field_id, s_counter) VALUES(620, 2, 3);
INSERT INTO statistics(item_id, statistics_field_id, s_counter) VALUES(620, 4, 3);
INSERT INTO statistics(item_id, statistics_field_id, s_counter) VALUES(621, 2, 3);
INSERT INTO statistics(item_id, statistics_field_id, s_counter) VALUES(621, 4, 3);
INSERT INTO statistics(item_id, statistics_field_id, s_counter) VALUES(622, 2, 3);
INSERT INTO statistics(item_id, statistics_field_id, s_counter) VALUES(622, 4, 3);
INSERT INTO statistics(item_id, statistics_field_id, s_counter) VALUES(623, 2, 3);
INSERT INTO statistics(item_id, statistics_field_id, s_counter) VALUES(613, 4, 3);
------------------------------------------------------------------------------------------------------------------->