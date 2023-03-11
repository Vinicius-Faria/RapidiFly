--liquibase formatted sql

--changeset viniciusfaria:1
CREATE TABLE public.login (
      id serial NOT NULL,
      nome text NOT NULL,
      senha text NOT NULL
);
--preconditions onFail:MARK_RAN onError:HALT
--precondition-sql-check expectedResult:0 select count(*) from information_schema.tables where table_schema = 'public' and table_name = 'login'
