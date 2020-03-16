CREATE TABLE IF NOT EXISTS usuario (
    user_id UUID PRIMARY KEY NOT NULL,
    user_name VARCHAR(100) NOT NULL,
    user_password VARCHAR(100) NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);