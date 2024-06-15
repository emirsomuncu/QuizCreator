package com.somuncu.QuizCreator.dao.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.somuncu.QuizCreator.model.Question;

public interface QuestionDao extends JpaRepository<Question, Integer>{

	public List<Question> findByCategory(String category);
	
	//Jpa bu kadar özel istekler için sorgu yazamaz sen burda query geçmelisin .
	
	@Query(value= "SELECT * FROM question q WHERE q.category=:category ORDER BY RAND() LIMIT :numQ" ,nativeQuery =true )
	public List<Question> findRandomQuestionByCategoryAndNumber(String category , int numQ);
}
