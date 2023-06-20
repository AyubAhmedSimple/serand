package com.serand.assignment.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CandidateSurveyScore")
public class CandidateSurveyScore {

	@Id
	private String id;
    private String surveyId;
	private Integer score;
	private String candidateId;
	private String submittedSurveyId;
	private String companyId;
	private Date timestamp;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(String surveyId) {
		this.surveyId = surveyId;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}
	public String getSubmittedSurveyId() {
		return submittedSurveyId;
	}
	public void setSubmittedSurveyId(String submittedSurveyId) {
		this.submittedSurveyId = submittedSurveyId;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	
}
