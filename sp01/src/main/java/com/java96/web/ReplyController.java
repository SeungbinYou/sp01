package com.java96.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java96.dto.Criteria;
import com.java96.dto.ReplyDTO;
import com.java96.service.ReplyService;

import lombok.extern.java.Log;

@RestController
@RequestMapping("/reply/*")
@Log
public class ReplyController {
	
	@Autowired
	private ReplyService service;

	
	@PostMapping("/new")
	public void addReply(@RequestBody ReplyDTO dto) {
		
		log.info("" + dto);
		service.register(dto);
	}
	
	@GetMapping("/{rno}")
	public ReplyDTO readReply(@PathVariable("rno") Integer rno ) {
		
		log.info("RNO: " + rno);
		return service.get(rno);
	}
	
	@DeleteMapping("/{rno}")
	public ResponseEntity<String> removeReply(@PathVariable("rno") Integer rno){
		
		log.info("Remove RNO: " + rno);
		
		service.remove(rno);
		
		return new ResponseEntity<String>("removed", HttpStatus.OK);
	}
	

	@PutMapping("/{rno}")
	public ResponseEntity<String> updateReply(
			@PathVariable("rno") Integer rno, @RequestBody ReplyDTO dto){
		
		dto.setRno(rno);
		
		log.info("Remove RNO: " + rno);
		
		service.update(dto);
		
		return new ResponseEntity<String>("removed", HttpStatus.OK);
	}
	
	@GetMapping("/list/{page}")
	public List<ReplyDTO> list(@PathVariable("page") int page){
		
		return service.listPage( new Criteria(page) );
	}


}
