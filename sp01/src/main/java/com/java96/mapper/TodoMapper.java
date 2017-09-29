package com.java96.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.java96.dto.Criteria;
import com.java96.dto.TodoDTO;

public interface TodoMapper {

	//get title, get writer = °Ù¸Þ¼Òµå ¾¸
	@Insert("insert into tbl_todo (title,writer) values (#{title}, #{writer})")
	public void insert(TodoDTO dto);
	
	
	@Update("UPDATE db_96.tbl_todo SET title = #{title} , writer = #{writer} where tno = #{tno}")
	public void update(TodoDTO dto);
	
	//¼Â¸Þ¼Òµå »ç¿ë
	@Select("select * from tbl_todo where tno = #{tno}")
	public TodoDTO findById(Long tno);
		
	
	//2017-09-20 mysql ÆäÀÌÂ¡ Ã³¸®
	public List<TodoDTO> listPage(Criteria cri);
	
	//2017-09-21 ÆäÀÌÂ¡ ÅäÅ» °¡Á®¿À±â
	@Select("select count(*) from tbl_todo where tno >0")
	public int getTotal(Criteria cri);
	
	public void removePage(Long tno);
	
	@Update("update tbl_todo set replycnt = replycnt + 1 where tno = #{tno}")
	public void updateReplyCnt(Long tno);
}
