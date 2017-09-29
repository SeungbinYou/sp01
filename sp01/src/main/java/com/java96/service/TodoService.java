package com.java96.service;

import java.util.List;

import com.java96.dto.Criteria;
import com.java96.dto.TodoDTO;

public interface TodoService {

	//기존에 db관련 용어가 아닌 고객에 관련된 비지니스 용어를 씀
	public TodoDTO get(Long tno);
	
	public void register(TodoDTO dto);
	//인터페이스는 타입으로 쓰기때문에 어노테이션 쓰지 않음 
	
	//2017-09-20
	//리스트 뿌리는거 할꺼임 크리테리아 사용
	public List<TodoDTO> list(Criteria cri);
	
	public void remove(Long tno);
	
	public void updateBoard(TodoDTO dto);

	public void modify(TodoDTO dto, Criteria cri);

	public void register(TodoDTO dto, String[] ufiles);
}
