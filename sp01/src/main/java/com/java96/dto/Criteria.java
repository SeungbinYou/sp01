package com.java96.dto;

public class Criteria {

	private int page;
	private int total;//2017-09-21+ 게터세터
		
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Criteria() {

		this(1);// 생성자에서 생성자를 호출하는 문법; 알아보자
	}
	
	public int getPage() {
		return page;
	}

	//list용도로 만듬 (음수를 확인해봐야 한다)
	public void setPage(int page) {
		 if(page <=0) {
			 page =1;
		 }
		
		this.page = page;
	}

	public Criteria(int page) {

		if (page <= 0) {

			page = 1;
		}

		this.page = page;
	}

	public int getSkip() {

		return (this.page - 1) * 10;

	}

	//마이바티츠에서 이놈을 파라미터로 받는다
	
	public String getURI() {
		return "page="+this.page;
		
	}
	
	
}
