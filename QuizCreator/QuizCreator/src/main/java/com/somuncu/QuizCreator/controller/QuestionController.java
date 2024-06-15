package com.somuncu.QuizCreator.controller;

import com.somuncu.QuizCreator.business.abstracts.QuestionService;
import com.somuncu.QuizCreator.model.Question;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@AllArgsConstructor
public class QuestionController {

    private QuestionService questionService ;

    @GetMapping("/")
    public String home() {
        return "home" ;
    }

    @GetMapping("/QuestionOperations")
    public String questionOperationPage() {
        return "/question/question-operations";
    }

    @GetMapping("/AllQuestions")
    public String allQuestions(Model model) {

        List<Question> questionList = this.questionService.getAllQuestions();
        model.addAttribute("questionList" , questionList);

        return "/question/all-questions";
    }

    @GetMapping("/CreateDeleteQuestions")
    public String createOrDeleteQuestions() {
        return "/question/create-delete-questions";
    }

    @RequestMapping("/CreateQuestion")
    public String createQuestion(Model model) {

        Question question = new Question();
        model.addAttribute("question" , question);

        return "/question/create-question-form";
    }

    @PostMapping("/SaveQuestions")
    public String saveQuestions(@Valid @ModelAttribute("question") Question question , BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            return "/question/create-question-form";
        }


        this.questionService.addQuestion(question);

        return "redirect:/AllQuestions";
    }

    @RequestMapping("/DeleteQuestion")
    public String deleteQuestion(Model model) {

        List<Question> questionList  =this.questionService.getAllQuestions();
        model.addAttribute("questionList", questionList);

        return "/question/delete-questions";
    }

    @RequestMapping("/EnsureDeleting")
    public String ensureDeleting(@RequestParam("id") int id) {

        this.questionService.deleteQuestion(id);

        return "redirect:/AllQuestions";
    }
}
