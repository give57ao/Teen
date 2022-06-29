package com.ez.teen.scrap.all;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ez.teen.board.model.BoardModel;
import com.ez.teen.board.model.BoardParam;
import com.ez.teen.member.model.MemberCardModel;
import com.ez.teen.scrap.mapper.ScrapMapper;

@Service
public class ScrapServiceImpl implements ScrapService{

	@Autowired
	private ScrapMapper scrapMapper;

	//게시글 스크랩하기
	@Override
	public void insertScrap(BoardModel boardModel) throws Exception {
		
		scrapMapper.insertScrap(boardModel);
	}

	//스크랩 중복 확인
	@Override
	public int countScrap(BoardModel boardModel) throws Exception {
		
		return scrapMapper.countScrap(boardModel);
	}

	//스크랩 리스트 출력
	@Override
	public List<BoardModel> scrapList(BoardParam boardParam) throws Exception {
		
		return scrapMapper.scrapList(boardParam);
	}

	//스크랩 카운트
	@Override
	public int getScrapCount(BoardParam boardParam) {
		
		return scrapMapper.getScrapCount(boardParam);
		
	}

	//스크랩한 게시글 삭제
	@Override
	public void deleteScrap(int scrap_no) {
		
		scrapMapper.deleteScrap(scrap_no);
		
	}

	
	
	
	
	
	
	
}
