package com.covisint.datamigration.core.dto;

import java.util.List;

public class SecurityQuestionAccountDTO {
	
	private String creator;
	private Integer creation;
	private String realm;
	private List<QuestionsDTO> questions;
	
	
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Integer getCreation() {
		return creation;
	}
	public void setCreation(Integer creation) {
		this.creation = creation;
	}
	public String getRealm() {
		return realm;
	}
	public void setRealm(String realm) {
		this.realm = realm;
	}
	public List<QuestionsDTO> getQuestions() {
		return questions;
	}
	public void setQuestions(List<QuestionsDTO> questions) {
		this.questions = questions;
	}
	
}
