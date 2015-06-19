DELETE FROM user_roles;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

-- password
INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password');
-- admin
INSERT INTO users (name, email, password)
VALUES ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES ('ROLE_USER', 100000);
INSERT INTO user_roles (role, user_id) VALUES ('ROLE_ADMIN', 100001);

INSERT INTO procedures (datetime, description, scores, user_id) VALUES (TIMESTAMP '2015-01-06 09:00', 'жим', 500, 100000);
INSERT INTO procedures (datetime, description, scores, user_id) VALUES (TIMESTAMP '2015-01-06 13:00', 'присед', 1000, 100000);
INSERT INTO procedures (datetime, description, scores, user_id) VALUES (TIMESTAMP '2015-01-07 00:00', 'становая', 600, 100000);
INSERT INTO procedures (datetime, description, scores, user_id) VALUES (TIMESTAMP '2015-01-07 13:00', 'жим', 1300, 100000);
INSERT INTO procedures (datetime, description, scores, user_id) VALUES (TIMESTAMP '2015-01-06 14:00', 'другое', 2000, 100001);
