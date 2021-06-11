package com.covisint.datamigration.core.dto;

public class QuestionsDTO {
	
	private ReferenceDTO question;
	private String answer;
	private Integer index;
	
	
	public ReferenceDTO getQuestion() {
		return question;
	}
	public void setQuestion(ReferenceDTO question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
}
