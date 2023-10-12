package com.studiostg.article.model.dao;

import com.studiostg.article.model.bean.Evaluator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluatorRepository extends JpaRepository<Evaluator, Long> {}
