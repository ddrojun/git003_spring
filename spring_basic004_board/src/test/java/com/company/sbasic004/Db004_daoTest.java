package com.company.sbasic004;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.company.dao.SboardDao;
import com.company.dto.SboardDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class Db004_daoTest {
	@Autowired
	private SboardDao dao;

//	@Test
//	public void test_insert() throws Exception{
//		SboardDto dto = new SboardDto();
//		dto.setBname("aaa");
//		dto.setBpass("aaa");
//		dto.setBtitle("aaa");
//		dto.setBcontent("aaa");
//		dto.setBip(InetAddress.getLocalHost().getHostAddress());
//		System.out.println("INSERT확인 : " +dao.insertSboard(dto));
//		
//	}

//	@Test
//	public void test_selectAll() throws Exception {
//		System.out.println(dao.selectSboardAll());
//	}

//	@Test
//	public void test_select() throws Exception {
//		SboardDto dto = new SboardDto();
//		dto.setBno(2);
//		System.out.println(dao.selectSboard(dto));
//	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Rollback(false)

	@Test
	public void test_update() throws Exception {
		SboardDto dto = new SboardDto();
		dto.setBtitle("new");
		dto.setBcontent("new");
		dto.setBno(1);
		dto.setBpass("aaa");
		System.out.println("4 : " + dao.updateSboard(dto));
		System.out.println("5 : " + dao.selectSboard(dto));

	}

//	@Test
//	public void test_delete() throws Exception{
//		SboardDto dto = new SboardDto();
//		dto.setBno(1);
//		dto.setBpass("aaa");
//		System.out.println(dao.deleteSboard(dto));
//	}

	/////
	@Test
	public void test_selectAll() throws Exception{
		SboardDto dto = new SboardDto();
		dto.setBtitle("1");
		System.out.println(dao.searchSboard(dto));
	}
	
	
}// end class
