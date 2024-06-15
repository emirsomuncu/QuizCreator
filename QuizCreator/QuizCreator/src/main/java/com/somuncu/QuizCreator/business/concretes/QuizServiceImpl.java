package com.somuncu.QuizCreator.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.somuncu.QuizCreator.business.abstracts.QuizService;
import com.somuncu.QuizCreator.business.response.GetQuizQuestionsResponse;
import com.somuncu.QuizCreator.core.utilites.mappers.ModelMapperService;
import com.somuncu.QuizCreator.dao.abstracts.QuestionDao;
import com.somuncu.QuizCreator.dao.abstracts.QuizDao;
import com.somuncu.QuizCreator.model.Question;
import com.somuncu.QuizCreator.model.Quiz;
import com.somuncu.QuizCreator.model.Response;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuizServiceImpl implements QuizService {

	private QuizDao quizDao;
	private QuestionDao questionDao;
	private ModelMapperService modelMapperService;

	@Override
	public String createQuiz(String category, int numQ, String title) {
		
		List<Question> questions = this.questionDao
				.findRandomQuestionByCategoryAndNumber(category , numQ);
		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestion(questions);
		
		quizDao.save(quiz);
		
		return "successfully created the quiz";
	}

    @Override
    public List<GetQuizQuestionsResponse>  getQuizQuestionByTitle(String title) {

         Quiz quiz = this.quizDao.findByTitle(title);
         List<Question> questionList = quiz.getQuestion();

         List<GetQuizQuestionsResponse> getQuizQuestionsResponse = questionList.stream().map(qL -> this.modelMapperService
                 .forResponse().map(qL,GetQuizQuestionsResponse.class)).toList();

         return getQuizQuestionsResponse ;

    }

    @Override
	public List<GetQuizQuestionsResponse> getQuizQuestions(int id) {
		Optional<Quiz> quiz = this.quizDao.findById(id);
		                            // to fetch object that in the optional type
		List<Question> quizQuestions = quiz.get().getQuestion();
		List<GetQuizQuestionsResponse> questionForResponse = quizQuestions.stream().map(qfr->this.modelMapperService
				.forResponse().map(qfr, GetQuizQuestionsResponse.class)).toList();
		return questionForResponse;
	}


}
