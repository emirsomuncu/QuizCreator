package com.somuncu.QuizCreator.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.somuncu.QuizCreator.business.abstracts.QuestionService;
import com.somuncu.QuizCreator.dao.abstracts.QuestionDao;
import com.somuncu.QuizCreator.model.Question;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService{

	private QuestionDao questionDao;

	@Override
	public List<Question> getAllQuestions() {
		List<Question> questions = this.questionDao.findAll();
		return questions;
	}

	@Override
	public List<Question> getQuestionByCategory(String category) {
		List<Question> questionByCategory = this.questionDao.findByCategory(category);
		return questionByCategory;
	}

	@Override
	public Question addQuestion(Question question) {
		return this.questionDao.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		return this.questionDao.save(question);
	}

	@Override
	public void deleteQuestion(int id) {
		this.questionDao.deleteById(id);
	}
	
}
