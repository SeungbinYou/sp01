package com.java96.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.java96.dto.Criteria;
import com.java96.dto.TodoDTO;
import com.java96.mapper.TodoMapper;

import lombok.extern.java.Log;

@Service
@Log
public class TodoServiceImpl implements TodoService {

	@Inject
	private TodoMapper mapper;
	

	@Override
	public TodoDTO get(Long tno) {
		log.info("service get" + tno);
		return mapper.findById(tno);
	}

	@Override
	public void register(TodoDTO dto) {
		log.info("service register"+dto);
		mapper.insert(dto);

	}

	//2017-09-20 list 메소드 구현
	@Override
	public List<TodoDTO> list(Criteria cri) {
		//2017-09-21 cri 수정후 토탈 넘버 넣는다
		cri.setTotal(mapper.getTotal(cri));
		
		return mapper.listPage(cri);
	}

	@Override
	public void remove(Long tno) {
		mapper.removePage(tno);
		
	}

	@Override
	public void updateBoard(TodoDTO dto) {
		mapper.update(dto);
		
	}

	@Override
	public void modify(TodoDTO dto, Criteria cri) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void register(TodoDTO dto, String[] ufiles) {
		// TODO Auto-generated method stub
		
	}

}
