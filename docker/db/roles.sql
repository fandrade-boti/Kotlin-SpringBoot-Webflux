-- Revoke privileges from 'public' role

REVOKE CREATE ON SCHEMA public FROM PUBLIC;

-- Read-only role

CREATE ROLE template_readonly;

GRANT USAGE ON SCHEMA public TO template_readonly;
GRANT SELECT ON ALL TABLES IN SCHEMA public TO template_readonly;
GRANT SELECT ON ALL SEQUENCES IN SCHEMA public TO template_readonly;

ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT SELECT ON TABLES TO template_readonly;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT SELECT ON SEQUENCES TO template_readonly;

-- Read/write role

CREATE ROLE template_readwrite;

GRANT USAGE, CREATE ON SCHEMA public TO template_readwrite;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO template_readwrite;
GRANT USAGE ON ALL SEQUENCES IN SCHEMA public TO template_readwrite;

ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT SELECT, INSERT, UPDATE, DELETE ON TABLES TO template_readwrite;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT USAGE ON SEQUENCES TO template_readwrite;

-- Create a final user with password

CREATE USER readonly WITH PASSWORD 'test';
CREATE USER application WITH PASSWORD 'test';


-- Grant privileges to users

GRANT template_readonly TO readonly;
GRANT template_readwrite TO application;
--GRANT rds_superuser to migration;
