package com.somuncu.QuizCreator.controller;

import com.somuncu.QuizCreator.business.abstracts.QuizService;
import com.somuncu.QuizCreator.business.response.GetQuizQuestionsResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class QuizController {

    private QuizService quizService ;

    @GetMapping("/QuizOperations")
    public String quizOperations() {
        return "/quiz/quiz-operations";
    }

    @RequestMapping("/CreateQuiz")
    public String createQuiz() {

        return "/quiz/create-quiz-form";
    }


    @GetMapping("/saveQuiz")
    public String saveQuiz(@RequestParam String category , @RequestParam int numQ , @RequestParam String title) {

        this.quizService.createQuiz(category,numQ,title);

        return "redirect:/FindQuiz";

    }

    @RequestMapping("/FindQuiz")
    public String findQuiz(){
        return "/quiz/find-quiz";
    }

    @RequestMapping("/ShowQuiz")
    public String showQuiz(@RequestParam String title , Model model) {

        List<GetQuizQuestionsResponse> getQuizQuestionsResponse = this.quizService.getQuizQuestionByTitle(title);
        model.addAttribute("getQuizQuestionsResponse" , getQuizQuestionsResponse);

        return "/quiz/show-quiz";
    }
}
