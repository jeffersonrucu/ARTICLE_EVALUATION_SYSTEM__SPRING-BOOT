ALTER TABLE user
    ADD CONSTRAINT fk_user_id_person
    FOREIGN KEY (id_person)
    REFERENCES person(id)
;