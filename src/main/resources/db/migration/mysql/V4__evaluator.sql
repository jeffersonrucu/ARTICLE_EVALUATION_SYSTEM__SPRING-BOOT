CREATE TABLE evaluator (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_person BIGINT NOT NULL,
    FOREIGN KEY (id_person) REFERENCES person(id)
);