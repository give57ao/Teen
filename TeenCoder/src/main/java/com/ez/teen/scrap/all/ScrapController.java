package com.ez.teen.scrap.all;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ez.teen.board.model.BoardModel;
import com.ez.teen.board.model.BoardParam;

@Controller
@RequestMapping(value = "/scrap")
public class ScrapController {
	
	
	@Autowired
	private ScrapService scrapService;

	
	@PostMapping(value = "/insertScrap")
	@ResponseBody
	public String insertScrap(BoardModel boardModel, HttpServletRequest request, HttpSession session) throws Exception {

		int member_no = (Integer) session.getAttribute("member_no");
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		String member_nick = (String)request.getParameter("member_nick");

		boardModel.setMember_no(member_no);
		boardModel.setBoard_no(board_no);
		boardModel.setMember_nick(member_nick);

		int Result = scrapService.countScrap(boardModel);

		try {
			if (Result == 0) {

				scrapService.insertScrap(boardModel);

				return "1";

			} else if (Result > 0) {

				return "0";
			}

		} catch (Exception e) {
			throw new RuntimeException();

		}

		return "redirect:/board/Detail";

	}
	
	
	@RequestMapping(value = "/scrapList")
	public String scrpaList(BoardModel boardModel, Model model, HttpSession session,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "search", required = false) String search,
			@RequestParam(value = "keyword", required = false) String keyword,
	         BoardParam boardParam)throws Exception {
		
		int member_no = (Integer)session.getAttribute("member_no");
		boardParam.setMember_no(member_no);
		
		int total = scrapService.getScrapCount(boardParam);

		System.out.println("total :" + total);
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "10";
		}
		boardParam.PagingModel(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		if (total == 0) {
			boardParam.setEndPage(1);
		}
		
		
		
		List<BoardModel> scrapList = scrapService.scrapList(boardParam);
		
		model.addAttribute("scrapList", scrapList);
		model.addAttribute("paging", boardParam);
		model.addAttribute("sort", sort);
		
		return "member/myScrap";
		
	}
	
	
	
	@RequestMapping(value = "/deleteScrap")
	public String deleteScrap(@RequestParam("scrap_no")int scrap_no, HttpServletRequest request)throws Exception{
			
		scrapService.deleteScrap(scrap_no);
		
		return "redirect:/scrap/scrapList";
	}
	
	@RequestMapping(value = "/deleteCardScrap")
	public void deleteCardScrap(@RequestParam("scrap_no")int scrap_no, HttpServletRequest request)throws Exception{
			
		scrapService.deleteScrap(scrap_no);
		
	}
	
}
