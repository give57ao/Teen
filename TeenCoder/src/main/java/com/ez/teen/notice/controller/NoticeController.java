package com.ez.teen.notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ez.teen.notice.model.NoticeModel;
import com.ez.teen.notice.model.NoticeParam;
import com.ez.teen.notice.service.NoticeService;

@Controller
@RequestMapping("/board")
public class NoticeController {

	@Autowired
	NoticeService noticeService;
	
	@GetMapping("/notice")
	public String noticeBoard(Model model, NoticeModel noticeModel, NoticeParam noticeParam,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage,
			@RequestParam(value = "search", required = false) String search,
			@RequestParam(value = "keyword", required = false) String keyword
			) {
		
		int total = noticeService.getNoticeCount(noticeParam);
		
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "10";
		} 
		noticeParam.PagingModel(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		if(total == 0) {
			noticeParam.setEndPage(1);
		}
		
		
		model.addAttribute("paging", noticeParam);
		model.addAttribute("notice", noticeService.noticeList(noticeParam));
		
		
		
		return "board/noticeBoard";
	}
}
