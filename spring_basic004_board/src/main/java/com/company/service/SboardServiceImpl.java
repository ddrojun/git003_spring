package com.company.service;

import java.io.File;
import java.net.InetAddress;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.company.dao.SboardDao;
import com.company.dto.SboardDto;
@Repository
public class SboardServiceImpl implements SboardService{
	@Autowired
	private SboardDao dao;
	
	@Override
	public int insertSboard(SboardDto dto, MultipartFile file, HttpServletRequest request) throws Exception {
		System.out.println("ㅁ name : " +file.getOriginalFilename());
		System.out.println("ㅁ size : " + file.getSize());
		System.out.println("ㅁ contentType : " +file.getContentType());
		 //1. 파일이름중복되지않게 처리
		 UUID uid = UUID.randomUUID(); //중복되지 않는 키
		 String filename =uid.toString() +"_" +file.getOriginalFilename(); 
		 String uploadpath = request.getSession().getServletContext().getRealPath("/") + "upload";
		 System.out.println("ㅁ uploadpath : " +uploadpath);
		 
		 File target = new File(uploadpath, filename );	//File(파일경로, 파일이름)
		 FileCopyUtils.copy(file.getBytes(), target);
		 
		 //2. 파일 업로드
		 //3. model이용해서 데이터 넘기기		
		///
		dto.setBfile(filename);
		dto.setBip(InetAddress.getLocalHost().getHostAddress());
		return dao.insertSboard(dto);
	}

	@Override
	public List<SboardDto> selectSboardAll() throws Exception {
		return dao.selectSboardAll();
	}

	@Override
	public SboardDto selectSboard(SboardDto dto) throws Exception {
		return dao.selectSboard(dto);
	}

	@Override
	public int updateSboardBhit(SboardDto dto) throws Exception {
		return dao.updateSboardBhit(dto);
	}
	@Override
	public int updateSboard(SboardDto dto) throws Exception {	
		return dao.updateSboard(dto);
	}

	@Override
	public int deleteSboard(SboardDto dto) throws Exception {
		return dao.deleteSboard(dto);
	}
	////
	@Override
	public List<SboardDto> searchSboard(SboardDto dto ) throws Exception{
		return dao.searchSboard(dto);
	}
	
}//end class
