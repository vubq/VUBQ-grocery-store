-- The PostgreSQL image already creates the database defined by POSTGRES_DB.
\set ON_ERROR_STOP on
\i /docker-entrypoint-initdb.d/migration/V1__init.sql
\i /docker-entrypoint-initdb.d/seed.sql
