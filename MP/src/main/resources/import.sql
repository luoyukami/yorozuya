
INSERT INTO role(	id, name)	VALUES ('a0b2b514-8c9e-4c6f-86ee-1e46f97f3d34', 'ROLE_ADMIN');
INSERT INTO role(	id, name)	VALUES ('291e74f9-773d-48b1-b105-defe0de13b6a', 'ROLE_USER_GROUP');
INSERT INTO role(	id, name)	VALUES ('71f72740-e609-4e4f-88e7-4bbed3390821', 'ROLE_USER_REGION');
INSERT INTO role(	id, name)	VALUES ('3d2e960d-318d-45d6-b322-a62e6d78f05c', 'ROLE_USER_STATION');

INSERT INTO sys_user(id,username,password,email,last_pwd_reset_date) VALUES ('8e703264-b036-44b7-8222-398981a96d6d','admin','$2a$10$v4vrWiqrVmJR0fT0T/Ogxu041nwGHO9pA6gbPC43uKXVrIZcyVlx6','admin@localhost.com',getDate());
INSERT INTO sys_user(id,username,password,email,last_pwd_reset_date) VALUES ('43508def-3086-46e4-b748-96f656f79cc1','fy','$2a$10$22rZCwDjh5X/TJelo9p4Du1GFH0vuzTAJkr96pm1C/bDLEPpo1Xwq','fy@localhost.com',getDate());

INSERT INTO user_role(user_id,role_id) VALUES ('8e703264-b036-44b7-8222-398981a96d6d','a0b2b514-8c9e-4c6f-86ee-1e46f97f3d34');
INSERT INTO user_role(user_id,role_id) VALUES ('8e703264-b036-44b7-8222-398981a96d6d','291e74f9-773d-48b1-b105-defe0de13b6a');
INSERT INTO user_role(user_id,role_id) VALUES ('8e703264-b036-44b7-8222-398981a96d6d','71f72740-e609-4e4f-88e7-4bbed3390821');
INSERT INTO user_role(user_id,role_id) VALUES ('8e703264-b036-44b7-8222-398981a96d6d','3d2e960d-318d-45d6-b322-a62e6d78f05c');
INSERT INTO user_role(user_id,role_id) VALUES ('43508def-3086-46e4-b748-96f656f79cc1','a0b2b514-8c9e-4c6f-86ee-1e46f97f3d34')



