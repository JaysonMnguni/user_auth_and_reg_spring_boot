USE user_auth_v1;


-- USER TABLE STRUCTURE:
CREATE TABLE users(
    user_id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(50)  NOT NULL,
    last_name VARCHAR(50)  NOT NULL,
    email VARCHAR(255)  NOT NULL UNIQUE,
    password VARCHAR(255)  NOT NULL,
    token VARCHAR(255)  NULL,
    code INT DEFAULT 0,
    verified INT DEFAULT 0,
    verified_at DATETIME,
    created_at TIMESTAMP,
    updated_at DATETIME,
    PRIMARY KEY(user_id)
);