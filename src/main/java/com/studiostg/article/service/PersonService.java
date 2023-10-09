package com.studiostg.article.service;

import com.studiostg.article.model.bean.Person;
import com.studiostg.article.model.dao.PersonRepository;
import com.studiostg.article.model.dto.person.PersonCreateDTO;
import com.studiostg.article.model.dto.person.PersonUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    public List<Person> index() {
        return repository.findAll();
    }

    public Person create(PersonCreateDTO personDTO) {
        Person person = new Person(personDTO.name(), personDTO.gender());
        repository.save(person);
        return person;
    }

    public Optional<Person> read(Long id) {
        Optional<Person> person = repository.findById(id);

        return person;
    }

    public Optional<Person> update(PersonUpdateDTO personDTO) {
        Optional<Person> personNew = repository.findById(personDTO.id());

        personNew.ifPresent(person -> {
            if(personDTO.name() != null) {
                person.setName(personDTO.name());
            }

            if(personDTO.gender() != null) {
                person.setGender(personDTO.gender());
            }

            repository.save(person);
        });

        return personNew;
    }

    public boolean delete(Long id) {
        boolean isExist = repository.existsById(id);

        if(isExist) repository.deleteById(id);

        return isExist;
    }
}
