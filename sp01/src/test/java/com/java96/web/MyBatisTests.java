package com.java96.web;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.java96.mapper.TimeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class MyBatisTests {

	@Inject
	SqlSessionFactory factory;
	//������ ���� ������ spring -jdbc�� ��ġ �ȵǼ� �׷� 
	@Test
	public void test1() {
		System.out.println(factory);
	}
	@Inject
	TimeMapper timeMapper;
	
	@Test
	public void test2() {
		
		System.out.println(timeMapper.getTime());
	}
	
	@Test
	public void test3() {
		
		System.out.println(timeMapper.getTime2());
	}
}
