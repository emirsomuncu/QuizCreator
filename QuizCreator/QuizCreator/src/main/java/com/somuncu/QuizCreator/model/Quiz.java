package com.somuncu.QuizCreator.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "quiz")
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id ;
	
	@Column(name="title")
	private String title;
	
	//Many to many çözümü 3. bir tablo ile yapıyor . 
	//Many to one veya one to many gibi bir tabloya kolon ekleyerek değil
	@ManyToMany //bir quizde birden fazla soru olabilir , bir soru birden fazla quizde olabilir .
	private List<Question> question ;
}
