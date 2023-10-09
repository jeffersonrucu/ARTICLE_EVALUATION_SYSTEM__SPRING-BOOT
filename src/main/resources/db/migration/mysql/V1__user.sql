CREATE TABLE user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_person BIGINT NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    permission INT NOT NULL,
    inactive BOOLEAN NOT NULL
);
