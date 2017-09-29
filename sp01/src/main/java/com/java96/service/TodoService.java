package com.java96.service;

import java.util.List;

import com.java96.dto.Criteria;
import com.java96.dto.TodoDTO;

public interface TodoService {

	//������ db���� �� �ƴ� ���� ���õ� �����Ͻ� �� ��
	public TodoDTO get(Long tno);
	
	public void register(TodoDTO dto);
	//�������̽��� Ÿ������ ���⶧���� ������̼� ���� ���� 
	
	//2017-09-20
	//����Ʈ �Ѹ��°� �Ҳ��� ũ���׸��� ���
	public List<TodoDTO> list(Criteria cri);
	
	public void remove(Long tno);
	
	public void updateBoard(TodoDTO dto);

	public void modify(TodoDTO dto, Criteria cri);

	public void register(TodoDTO dto, String[] ufiles);
}
