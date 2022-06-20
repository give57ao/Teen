package com.ez.teen.board.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ez.teen.board.model.BoardAnswerModel;
import com.ez.teen.board.model.BoardCommentModel;
import com.ez.teen.board.model.BoardModel;
import com.ez.teen.board.model.BoardParam;
import com.ez.teen.board.model.CommentModel;
import com.ez.teen.board.model.CommentParam;

@Mapper
public interface BoardMapper {

	// 전체 이용자 수
	public int getUserCount();

	// 전체 게시글 수
	public int getBoardCount(BoardParam boardParam);

	// 전체 댓글 수
	public int getCommentCount(CommentParam commentParam);

	// 게시글 리스트 (BGROUP 구별없이)
	public List<BoardModel> boardList(BoardParam boardParam);

	// 댓글 리스트
	public List<CommentModel> commentList(CommentParam commentParam);

	// 게시글 수정
	public void updateBoard(BoardModel boardModel);

	// 게시글 디테일
	public List<BoardModel> selectBoardDetail(BoardParam boardParam);

	// 게시글 디테일 속 댓글
	public List<BoardCommentModel> selectComment(BoardParam boardParam);

	// 게시글 디테일 속 답글
	public List<BoardAnswerModel> selectAnswer(BoardParam boardParam);

	// 게시글 작성
	public void insertBoard(BoardModel boardModel) throws Exception;

	// 첨부파일 업로드
	public void insertFile(Map<String, Object> map) throws Exception;

	// 첨부파일 조회
	public List<Map<String, Object>> selectFile(int board_no) throws Exception;

	// 첨부파일 다운로드
	public Map<String, Object> downFile(Map<String, Object> map) throws Exception;

	// 첨부파일 수정
	public void updateFile(Map<String, Object> map) throws Exception;

	// 댓글 작성
	public void insertComment(CommentModel commentModel);

	// 조회수 증가
	public void hitCount(BoardModel boardModel);

	// 추천수 증가
	public void recommendBoard(BoardModel boardModel);

	public void fileCk(BoardModel boardModel);

	public int getRefStep(int board_no);

	public int getRefLevel(CommentParam commentParam);

	// 답글 작성
	public void insertReComment(CommentModel commentModel);

	public void insertSummerNote(String fileName);

	public void updateTagName(BoardModel boardModel);

	// 댓글 첨부파일 추가
	public void insertCmtFile(Map<String, Object> map) throws Exception;

	public void deleteBoard(int board_no);

	public void deleteFile(int file_no);

	public void deleteBcomment(int bcomment_no);

	// detail내 댓글개수
	public int commentCount(int board_no);

	// detail내 답글개수
	public List<BoardAnswerModel> answerCount(BoardParam boardParam);
	
	public int getBoardLike(BoardParam boardParam) throws Exception;
	
	public void insertBoardLike(BoardModel boardModel) throws Exception;
	
	public void deleteBoardLike(BoardModel boardModel) throws Exception;
	
	public void updateBoardLike(int board_no) throws Exception;

	// 댓글 수정
	public void modifyComment(CommentModel commentModel) throws Exception;

	//댓글 첨부파일 수정
	public void updateCmtFile(CommentModel commentModel);

	
}
