package com.somuncu.QuizCreator.business.abstracts;

import java.util.List;

import com.somuncu.QuizCreator.model.Question;

public interface QuestionService {

	public List<Question> getAllQuestions();
	public List<Question> getQuestionByCategory(String category);
	public Question addQuestion(Question question);
	// Dönüş tipi String de olabilirdi . String olsaydı ekrana eklenen soruyu veremezdinde bir mesaj geçerdins
	
	public Question updateQuestion(Question question);
	public void deleteQuestion(int id);
}
