DROP TABLE IF EXISTS answer;

DROP TABLE IF EXISTS pool_user;

DROP TABLE IF EXISTS user_id;

DROP SEQUENCE IF EXISTS user_seq;

DROP TABLE IF EXISTS question;

DROP SEQUENCE IF EXISTS question_seq;

DROP TABLE IF EXISTS pool;

DROP SEQUENCE IF EXISTS pool_seq;


create sequence if not exists POOL_SEQ;
create table if not exists POOL
(
    POOL_ID     bigint not null default nextval('POOL_SEQ'),
    NAME        varchar(30),
    CREATE_DATE date,
    FINISH_DATE date,
    constraint POOL_ID_PK
        primary key (POOL_ID)
);

create sequence if not exists QUESTION_SEQ start with 1;
create table if not exists QUESTION
(
    QUESTION_ID   bigint not null default nextval('QUESTION_SEQ'),
    QUESTION_TEXT clob,
    QUESTION_TYPE bigint,
    POOL_ID       bigint,
    constraint QUESTION_ID_PK
        primary key (QUESTION_ID)
);
alter table QUESTION
    add constraint FK_POOL_ID_0
        foreign key (POOL_ID)
            references POOL (POOL_ID);

create sequence if not exists USER_SEQ start with 1;
create table if not exists USER_ID
(
    USER_ID bigint not null default nextval('USER_SEQ'),
    constraint USER_ID_PK
        primary key (USER_ID)
);

create table if not exists POOL_USER
(
    POOL_ID bigint not null,
    USER_ID bigint not null,
    constraint PK_POOL_USER
        primary key (POOL_ID, USER_ID),
    constraint FK_POOL_ID_1
        foreign key (POOL_ID)
            references POOL (POOL_ID),
    constraint FK_USER_ID_1
        foreign key (USER_ID)
            references USER_ID (USER_ID)
);

CREATE TABLE IF NOT EXISTS answer
(
    question_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    answer TEXT,
    CONSTRAINT pk_answer PRIMARY KEY (question_id, user_id),
    CONSTRAINT fk_question_id FOREIGN KEY (question_id) REFERENCES question(question_id),
    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES user_id(user_id)
);