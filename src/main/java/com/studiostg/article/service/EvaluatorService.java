package com.studiostg.article.service;

import com.studiostg.article.model.bean.Evaluator;
import com.studiostg.article.model.bean.Person;
import com.studiostg.article.model.dao.EvaluatorRepository;
import com.studiostg.article.model.dto.evaluator.EvaluatorCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvaluatorService {

    @Autowired
    private EvaluatorRepository repository;

    public List<Evaluator> index() {
        return repository.findAll();
    }

    public Evaluator create(EvaluatorCreateDTO evaluatorDTO, Person person) {
        Evaluator evaluator = new Evaluator(person);
        repository.save(evaluator);

        return evaluator;
    }

    public Optional<Evaluator> read(Long id) {
        return repository.findById(id);
    }

    public void update() {
    }

    public boolean delete(Long id) {
        boolean isExist = repository.existsById(id);

        if(isExist) {
            repository.deleteById(id);
        }

        return isExist;
    }
}
