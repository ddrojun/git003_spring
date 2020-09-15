package com.company.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.dto.SboardDto;
import com.company.service.SboardService;

@Controller
@RequestMapping("/board/*")
public class SboardController {
	private static final Logger Logger = LoggerFactory.getLogger(SboardController.class);
	
	@Autowired
	private SboardService service;
	
	
	
	@RequestMapping(value="/board_write", method=RequestMethod.GET)
	public String board_write_get() {
		Logger.info(":::::::: BOARD-GET- 글쓰기폼");
		return "/board/board_write";
	}
	@RequestMapping(value="/board_write", method=RequestMethod.POST)
	public String board_wirte_post(SboardDto dto, RedirectAttributes rttr, HttpServletRequest request, MultipartFile file)
			throws Exception {
		Logger.info(":::::::: BOARD-GET-글쓰기 기능");
		String result ="fail";
		if(service.insertSboard(dto, file, request) > 0)
		{
			result ="success"; 
			rttr.addFlashAttribute("insert", result);
		}
		return "redirect:/board/list";
	}	
	@RequestMapping(value="/list", method = {RequestMethod.POST, RequestMethod.GET })
	public String board_list(Model model)throws Exception {
		Logger.info("::::::: BOARD-GET-리스트");
		model.addAttribute("list", service.selectSboardAll());
		return "/board/list";
	}
	@RequestMapping(value="/board_detail", method=RequestMethod.GET)
	public String board_detail_get(@RequestParam("bno") int bno, Model model) throws Exception {
		Logger.info(":::::::: BOARD-GET- 상세보기폼 ");
		SboardDto dto = new SboardDto();
		dto.setBno(bno);
		service.updateSboardBhit(dto);
		model.addAttribute("SboardDto", service.selectSboard(dto));
		return "/board/board_detail";
	}
	@RequestMapping(value="/board_delete", method=RequestMethod.GET)
	public String board_delete_get(@RequestParam("bno") int bno, Model model) throws Exception {
		Logger.info("::::::::: BOARD-GET-삭제하기 폼");
		SboardDto dto = new SboardDto();
		dto.setBno(bno);
		model.addAttribute("SboardDto", service.selectSboard(dto));
		return "/board/board_delete";
	}
	@RequestMapping(value="/board_delete", method=RequestMethod.POST)
	public String board_delete_post(@RequestParam("bno") int bno, @RequestParam("bpass") String bpass, 
			RedirectAttributes rttr, HttpServletResponse response) throws Exception {
		Logger.info(":::::::: BOARD-GET- 삭제하기 기능 ");
		PrintWriter out = response.getWriter();
		
		SboardDto dto = new SboardDto();
		dto.setBno(bno);
		dto.setBpass(bpass);
		String result = "fail";
		if(service.deleteSboard(dto) > 0)
		{
			result ="success";
			rttr.addFlashAttribute("delete", result);
		}
		
		return "redirect:/board/list";
	}	
	@RequestMapping(value="/board_modify", method=RequestMethod.GET)
	public String board_modify_get(@RequestParam("bno") int bno, Model model) throws Exception {
		Logger.info(":::::::: BOARD-GET- 수정하기폼 ");
		SboardDto dto = new SboardDto();
		dto.setBno(bno);
		model.addAttribute("SboardDto",service.selectSboard(dto));
		return "/board/board_modify";
	}
	@RequestMapping(value="/board_modify", method=RequestMethod.POST)
	public String board_modify_post(MultipartFile file, HttpServletRequest request, SboardDto dto, RedirectAttributes rttr, @RequestParam("bno") int bno )throws Exception {
		Logger.info(":::::::: BOARD-GET- 수정하기 기능 ");
		String result ="fail";
		/////////////////////////////
		UUID uid = UUID.randomUUID();
		String filename = uid.toString() + "_" + file.getOriginalFilename();
		String uploadpath = request.getSession().getServletContext().getRealPath("/") + "/upload";
		File target = new File(uploadpath, filename);
		FileCopyUtils.copy(file.getBytes(), target);
		System.out.println(uid.toString().length());
		if (file.getOriginalFilename() != "") {
			dto.setBfile(filename);
		} else {
			dto.setBfile(request.getParameter("img"));
		}
		if(service.updateSboard(dto) > 0)
		{
			result ="success";
			rttr.addFlashAttribute("update", result);
		}
		return "redirect:/board/list";
	}
	//////////////////
//	@RequestMapping(value="searchData")
//	@ResponseBody
//	public String searchData(@RequestParam String title) throws Exception {
//		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//		System.out.println(service.searchList(title).size());
//		return "/board/list";
//	}
	
	
	
	
}//end class

