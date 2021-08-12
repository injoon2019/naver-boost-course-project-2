package com.ntscorp.project2.dto;


public class TodoDto {
	
	private long id;
	private String title;
	private String name;
	private int sequence;
	private String type;
	private String regDate;

	public TodoDto() {
	}

	public TodoDto(String title, String name, Integer sequence, String type) { //쓴다
		this.title = title;
		this.name = name;
		this.sequence = sequence;
		this.type = type;
	}
	
	public TodoDto(Long id, String title, String name, int sequence, String type, String regDate) {
		this.id = id;
		this.name = name;
		this.regDate = regDate;
		this.sequence = sequence;
		this.title = title;
		this.type = type;
	}

	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getRegDate() {
		return regDate;
	}
	
	public Integer getSequence() {
		return sequence;
	}
	
	public String getTitle() {
		return title;
	}

	public String getType() {
		return type;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "TodoDto [id=" + id + ", name=" + name + ", regDate=" + regDate + ", sequence=" + sequence + ", title="
				+ title + ", type=" + type + "]";
	}
}
