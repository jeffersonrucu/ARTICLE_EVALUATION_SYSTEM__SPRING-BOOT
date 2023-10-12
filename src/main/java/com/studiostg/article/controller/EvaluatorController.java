package com.studiostg.article.controller;

import com.studiostg.article.model.bean.Evaluator;
import com.studiostg.article.model.bean.Person;
import com.studiostg.article.model.dto.evaluator.EvaluatorCreateDTO;
import com.studiostg.article.service.EvaluatorService;
import com.studiostg.article.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/evaluator")
public class EvaluatorController {

    @Autowired
    private EvaluatorService service;

    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity index() {
        List<Evaluator> evaluatorList = service.index();
        return ResponseEntity.ok().body(evaluatorList);
    }

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody EvaluatorCreateDTO evaluatorDTO, UriComponentsBuilder uriBuilder) {
        Optional<Person> personOptional = personService.read(evaluatorDTO.id_person());

        if(!personOptional.isPresent()) return ResponseEntity.notFound().build();

        Person person = personOptional.get();
        Evaluator evaluator = service.create(evaluatorDTO, person);

        URI uri = uriBuilder.path("/evaluator/{id}").buildAndExpand(evaluator.getId()).toUri();
        return ResponseEntity.created(uri).body(evaluator);
    }

    @GetMapping("/{id}")
    public ResponseEntity read(@PathVariable Long id) {
        Optional<Evaluator> evaluator = service.read(id);

        if(!evaluator.isPresent()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(evaluator.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        boolean deleted = service.delete(id);

        if(!deleted)return ResponseEntity.notFound().build();

        return ResponseEntity.noContent().build();
    }
}
