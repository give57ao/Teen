package com.ez.teen.board.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ez.teen.board.model.BoardCommentModel;
import com.ez.teen.board.model.BoardModel;
import com.ez.teen.board.model.BoardParam;
import com.ez.teen.board.model.CommentModel;
import com.ez.teen.board.model.CommentParam;

@Mapper
public interface BoardMapper {

	
	// 전체 이용자 수
	public int getUserCount();

	//전체 게시글 수
	public int getBoardCount(BoardParam boardParam);
	
	// 전체 댓글 수
	public int getCommentCount(CommentParam commentParam);

	// 게시글 리스트 (BGROUP 구별 없이)
	public List<BoardModel> boardList(BoardParam boardParam);
	
	//게시글 디테일(dh)
	public List<BoardModel> selectBoardDetail(BoardParam boardParam);
	
	//댓글 리스트
	public List<CommentModel> commentList(CommentParam commentParam);
	
	//게시글 댓글 불러오기
	public List<BoardCommentModel> selectComment(BoardParam boardParam);
	
	/*
	 * // 기존에 있던 셀렉 보드 디테일 public BoardModel selectBoardDetail(int boardNum)throws
	 * Exception;
	 */	
	public void updateBoard(BoardModel boardModel);


	

	
	//게시글 작성
	public void insertBoard(BoardModel boardModel) throws Exception;
	
	//첨부파일 업로드
	public void insertFile(Map<String, Object> map) throws Exception;
	
	
}
