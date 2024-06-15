package com.somuncu.QuizCreator.dao.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.somuncu.QuizCreator.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer>{

    public Quiz findByTitle(String title);
}
