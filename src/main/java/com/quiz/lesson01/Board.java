package com.quiz.lesson01;

public class Board {
	//필드
	private String title;
	private String user;
	private String content;
	
	//메소드
	
	//기본 생성자
	public Board() {
		
	}
	
	//파라미터 있는 생성자
	public Board(String title, String user, String content) {
		this.title = title;
		this.user = user;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
