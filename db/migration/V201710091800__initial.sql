
CREATE SEQUENCE seq;

CREATE TABLE thing (
	thing_id BIGINT PRIMARY KEY,
	created TIMESTAMP WITH TIME ZONE NOT NULL,
	name TEXT NOT NULL,
	tags JSONB NOT NULL
);

