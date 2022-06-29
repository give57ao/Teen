package com.ez.teen.scrap.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ez.teen.board.model.BoardModel;
import com.ez.teen.board.model.BoardParam;
import com.ez.teen.member.model.MemberCardModel;

@Mapper
public interface ScrapMapper {

	//게시글 스크랩
	public void insertScrap(BoardModel boardModel)throws Exception;

	//중복확인
	public int countScrap(BoardModel boardModel);

	//스크랩 리스트
	public List<BoardModel> scrapList(BoardParam boardParam)throws Exception;

	//스크랩 카운트
	public int getScrapCount(BoardParam boardParam);

	//스크랩한 게시글 삭제
	public void deleteScrap(int scrap_no);

	


	
	
	
}
