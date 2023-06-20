package com.serand.assignment.model;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "questions")
public class Question {

	@Id
	private String id;
	private String questionText;
	private String answerText;
	private String type;
	private Map<String,String> specifyAnswer;
	private Map<String,String> specifyOptions;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Map<String, String> getSpecifyAnswer() {
		return specifyAnswer;
	}
	public void setSpecifyAnswer(Map<String, String> specifyAnswer) {
		this.specifyAnswer = specifyAnswer;
	}
	public Map<String, String> getSpecifyOptions() {
		return specifyOptions;
	}
	public void setSpecifyOptions(Map<String, String> specifyOptions) {
		this.specifyOptions = specifyOptions;
	}
	public String getAnswerText() {
		return answerText;
	}
	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}
	
}
