package com.studiostg.article.controller;

import com.studiostg.article.model.bean.Person;
import com.studiostg.article.model.dto.person.PersonCreateDTO;
import com.studiostg.article.model.dto.person.PersonUpdateDTO;
import com.studiostg.article.service.PersonService;
import com.studiostg.article.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping
    public ResponseEntity index() {
        List<Person> personList = service.index();
        return ResponseEntity.ok().body(personList);
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody PersonCreateDTO personDTO, UriComponentsBuilder uriBuilder) {
        Person person = service.create(personDTO);
        URI uri = uriBuilder.path("/person/{id}").buildAndExpand(person.getId()).toUri();
        return ResponseEntity.created(uri).body(person);
    }

    @GetMapping("{id}")
    public ResponseEntity read(@PathVariable Long id) {
        Optional<Person> person = service.read(id);

        if(!person.isPresent()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(person);
    }

    @PutMapping
    public ResponseEntity update(@Valid @RequestBody PersonUpdateDTO personDTO) {
        Optional<Person> person = service.update(personDTO);

        if(!person.isPresent()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(person.get());
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        boolean deleted = service.delete(id);

        if(!deleted) return ResponseEntity.notFound().build();

        return ResponseEntity.noContent().build();
    }
}
