package com.ez.teen.board.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ez.teen.board.mapper.BoardMapper;
import com.ez.teen.board.model.BoardModel;
import com.ez.teen.common.file.FileUtils;

@Service
public class BoardServiceImpl  implements BoardService{

	@Autowired
	BoardMapper boardMapper;
	
	@Resource(name = "fileUtils")
	FileUtils fileUtils;

	//전체 이용자 수
	@Override
	public int getUserCount() {
		return boardMapper.getUserCount();
	}

	//전체 게시글 수
	@Override
	public int getBoardCount() {
		return boardMapper.getBoardCount();
	}

	//전체 댓글 수
	@Override
	public int getCommentCount() {
		return boardMapper.getCommentCount();
	}

	
	//게시글 작성
	@Override
	public void insertBoard(BoardModel boardModel, MultipartHttpServletRequest mpRequest) throws Exception {
		
		boardMapper.insertBoard(boardModel);
		

		List<Map<String, Object>> list = fileUtils.parseInsertFileInfo(boardModel, mpRequest);
		
		int size = list.size();
		for(int i =0; i <size; i++) {
			boardMapper.insertFile(list.get(i));
		}
		
	}

	//첨부파일 추가
	@Override
	public void insertFile(Map<String, Object>map) throws Exception {
		
		boardMapper.insertFile(map);
		
	}

	


	
	

}
