package com.ez.teen.scrap.all;

import java.util.List;

import com.ez.teen.board.model.BoardModel;
import com.ez.teen.board.model.BoardParam;

public interface ScrapService {

	//게시글 스크랩하기
	public void insertScrap(BoardModel boardModel)throws Exception;
	
	//스크랩 중복 확인
	public int countScrap(BoardModel boardModel)throws Exception;
	
	//마이페이지 스크랩 리스트
	public List<BoardModel> scrapList(BoardParam boardParam)throws Exception;
	
	//스크랩 전체 카운트
	public int getScrapCount(BoardParam boardParam);
	
	//스크랩한 게시물 삭제
	public void deleteScrap(int scrap_no);
	
}
