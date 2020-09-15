package com.company.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.dto.SboardDto;
import com.company.service.SboardService;

@Controller
@RequestMapping("/boardajax/*")
public class AjaxController {
	private static final Logger Logger = LoggerFactory.getLogger(AjaxController.class);
	
	@Autowired
	private SboardService service;
	
	@RequestMapping(value="/searchBaord", method = {RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public List<SboardDto> board_list(@RequestParam("search") String search) throws Exception{
		Logger.info(":::::::::AJAX BOARD-GET-리스트");
		SboardDto dto = new SboardDto();
		dto.setBtitle(search);
		
		return service.searchSboard(dto);
	}//end board_list
	
	//////////////////
//	@RequestMapping(value="searchData")
//	@ResponseBody
//	public String searchData(@RequestParam String title) throws Exception {
//		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//		System.out.println(service.searchList(title).size());
//		return "/board/list";
//	}
	
	
	
	
}//end class

