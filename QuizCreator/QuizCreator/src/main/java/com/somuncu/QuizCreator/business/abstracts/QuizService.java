package com.somuncu.QuizCreator.business.abstracts;

import java.util.List;

import com.somuncu.QuizCreator.business.response.GetQuizQuestionsResponse;
import com.somuncu.QuizCreator.model.Quiz;
import com.somuncu.QuizCreator.model.Response;

public interface QuizService {

	public String createQuiz(String category, int numQ ,String title);

    public List<GetQuizQuestionsResponse>  getQuizQuestionByTitle(String title);
	public List<GetQuizQuestionsResponse> getQuizQuestions(int id);

}
