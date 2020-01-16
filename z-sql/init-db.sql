
-- 默认告警等级
INSERT INTO warning (id, `name`, `level`, warning_method, warning_impact, status, default_flag, create_time) VALUES (1, '蓝色预警', 1, 'EMAIL', 'NO_IMPACT', 1, 1, current_timestamp);
INSERT INTO warning (id, `name`, `level`, warning_method, warning_impact, status, default_flag, create_time) VALUES (2, '黄色预警', 2, 'EMAIL,WECHAT', 'CURRENT_TASK_SUSPEND', 1, 1, current_timestamp);
INSERT INTO warning (id, `name`, `level`, warning_method, warning_impact, status, default_flag, create_time) VALUES (3, '橙色预警', 3, 'EMAIL,SMS', 'CURRENT_TASK_ROLLBACK', 1, 1, current_timestamp);
INSERT INTO warning (id, `name`, `level`, warning_method, warning_impact, status, default_flag, create_time) VALUES (4, '红色预警', 4, 'EMAIL,WECHAT,SMS', 'CURRENT_AND_FUTURE_TASK_SUSPEND', 1, 1, current_timestamp);



