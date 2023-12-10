create table if not exists THREADS(
	id VARCHAR NOT NULL,
    title VARCHAR NOT NULL,
    content varchar,
    google_id VARCHAR,
        created_by VARCHAR(50),
        created_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
        updated_by VARCHAR(50),
        updated_timestamp TIMESTAMP,
        deleted boolean DEFAULT false NOT NULL,
        version_field integer DEFAULT 0 NOT NULL
);

create table if not exists THREAD_POSTS(
	id VARCHAR NOT NULL,
    title varchar,
    content varchar,
    google_id VARCHAR,
        thread_id VARCHAR,
        created_by VARCHAR(50),
        created_timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
        updated_by VARCHAR(50),
        updated_timestamp TIMESTAMP,
        deleted boolean DEFAULT false NOT NULL,
        version_field integer DEFAULT 0 NOT NULL
);

ALTER TABLE THREADS
ADD CONSTRAINT u_id_threads UNIQUE (id);

ALTER TABLE THREAD_POSTS
    ADD CONSTRAINT fk_thread FOREIGN KEY (thread_id) REFERENCES THREADS (id);