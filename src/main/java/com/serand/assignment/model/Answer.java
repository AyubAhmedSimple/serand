package com.serand.assignment.model;

import java.util.Map;

import org.springframework.data.annotation.Id;

public class Answer {

	@Id
	private String id;
	private String desc;
	private String offerredAnswerId;
	private String questionId;
	private String givenAnswerText;
	private Map<String,String> specifyAnswer;	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getOfferredAnswerId() {
		return offerredAnswerId;
	}
	public void setOfferredAnswerId(String offerredAnswerId) {
		this.offerredAnswerId = offerredAnswerId;
	}
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public Map<String, String> getSpecifyAnswer() {
		return specifyAnswer;
	}
	public void setSpecifyAnswer(Map<String, String> specifyAnswer) {
		this.specifyAnswer = specifyAnswer;
	}
	public String getGivenAnswerText() {
		return givenAnswerText;
	}
	public void setGivenAnswerText(String givenAnswerText) {
		this.givenAnswerText = givenAnswerText;
	}
}
