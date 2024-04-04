CREATE DATABASE students
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

CREATE TABLE IF NOT EXISTS public.student
(
    id BIGSERIAL PRIMARY KEY,
    name character varying COLLATE pg_catalog."default",
    document character varying COLLATE pg_catalog."default",
    course character varying COLLATE pg_catalog."default",
    age integer
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.student
    OWNER to postgres;
