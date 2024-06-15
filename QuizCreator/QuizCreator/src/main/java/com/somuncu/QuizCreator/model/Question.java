// you can named entity layer as model layer
package com.somuncu.QuizCreator.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    @NotNull
	private int id;
	
	@Column(name = "question_title")
    @Size(min = 1 , message = "Cannot be empyt")
	private String questionTitle;
	
	@Column(name = "option1")
    @Size(min = 1 , message = "Cannot be empyt")
	private String option1;
	
	@Column(name = "option2")
    @Size(min = 1 , message = "Cannot be empyt")
	private String option2;
	
	@Column(name = "option3")
    @Size(min = 1 , message = "Cannot be empyt")
	private String option3;
	
	@Column(name = "option4")
    @Size(min = 1 , message = "Cannot be empyt")
	private String option4;
	
	@Column(name = "right_answer")
    @Size(min = 1 , message = "Cannot be empyt")
	private String rightAnswer;
	
	@Column(name = "difficulty_level")
    @Size(min = 1 , message = "Cannot be empyt")
	private String difficultyLevel;
	
	@Column(name = "category")
    @Size(min = 1 , message = "Cannot be empyt")
	private String category;
}
