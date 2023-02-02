-- Создание схемы
CREATE SCHEMA IF NOT EXISTS my_store;

CREATE SEQUENCE IF NOT EXISTS my_store.my_store_id_seq;

-- Создание таблицы
CREATE TABLE IF NOT EXISTS my_store.order1
(
    id      integer NOT NULL DEFAULT nextval('my_store.my_store_id_seq'),
    name    text    NOT NULL,
    product text    NOT NULL,
    price   double precision,
    quality int
);

CREATE TABLE IF NOT EXISTS my_store.order2
(
    id      integer NOT NULL DEFAULT nextval('my_store.my_store_id_seq'),
    name    text    NOT NULL,
    product text    NOT NULL,
    price   double precision,
    quality int

);
DROP TABLE my_store.order1;
DROP TABLE my_store.order2;
-- Создание индекса
-- CREATE INDEX IF NOT EXISTS idx_user_status ON my_store.user USING hash (status);
alter table my_store.order2
    alter column id type SERIAL using id::SERIAL;

alter table my_store.order2
    alter column id drop default;

select * from my_store.order1
UNION ALL
select * from my_store.order2
