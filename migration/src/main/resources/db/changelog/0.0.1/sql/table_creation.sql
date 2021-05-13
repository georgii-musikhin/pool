CREATE SEQUENCE IF NOT EXISTS pool_seq
    START 1;

CREATE TABLE IF NOT EXISTS pool
(
    pool_id BIGINT NOT NULL DEFAULT nextval('pool_seq' :: regclass),
    name VARCHAR(30),
    create_date DATE,
    finish_date DATE,
    CONSTRAINT pool_id_pk PRIMARY KEY (pool_id)
);

CREATE SEQUENCE IF NOT EXISTS question_seq
    START 1;

CREATE TABLE IF NOT EXISTS question
(
    question_id BIGINT NOT NULL DEFAULT nextval('question_seq' :: regclass),
    question_text TEXT,
    question_type BIGINT,
    pool_id BIGINT,
    CONSTRAINT question_id_pk PRIMARY KEY (question_id)
);

ALTER TABLE question
    ADD CONSTRAINT fk_pool_id FOREIGN KEY (pool_id)
    REFERENCES pool(pool_id);

CREATE SEQUENCE IF NOT EXISTS user_seq
    START 1;

CREATE TABLE IF NOT EXISTS user_id
(
    user_id BIGINT NOT NULL DEFAULT nextval('user_seq' :: regclass),
    CONSTRAINT user_id_pk PRIMARY KEY (user_id)
);

CREATE TABLE IF NOT EXISTS pool_user
(
    pool_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    CONSTRAINT pk_pool_user PRIMARY KEY (pool_id, user_id),
    CONSTRAINT fk_pool_id FOREIGN KEY (pool_id) REFERENCES pool(pool_id),
    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES user_id(user_id)
);