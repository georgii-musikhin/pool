INSERT INTO pool(name, create_date) VALUES ('testPool', '2021-05-15');
INSERT INTO pool(name, create_date) VALUES ('testTwoPool', '2021-05-16');

INSERT INTO question (question_text, question_type, pool_id) VALUES ('questionOneText', 0, 1);
INSERT INTO question (question_text, question_type, pool_id) VALUES ('questionTWOText', 2, 1);

INSERT INTO user_id(user_id) VALUES (nextval('user_seq'));
INSERT INTO user_id(user_id) VALUES (nextval('user_seq'));

INSERT INTO pool_user(pool_id, user_id) VALUES (1, 1);
INSERT INTO pool_user(pool_id, user_id) VALUES (1, 2);

INSERT INTO answer(question_id, user_id, answer) VALUES (1, 1, 'firstAnswer');
INSERT INTO answer(question_id, user_id, answer) VALUES (1, 2, 'secondAnswer');