package com.bridgelabz.model;

import java.util.List;

public class Questions {
	private int id;
	private String qname;
	private List<Answers> answer;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQname() {
		return qname;
	}
	public void setQname(String qname) {
		this.qname = qname;
	}
	public List<Answers> getAnswer() {
		return answer;
	}
	public void setAnswer(List<Answers> answer) {
		this.answer = answer;
	}

}
