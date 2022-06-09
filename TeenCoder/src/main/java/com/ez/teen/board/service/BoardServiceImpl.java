package com.ez.teen.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ez.teen.board.mapper.BoardMapper;
import com.ez.teen.board.model.BoardAnswerModel;
import com.ez.teen.board.model.BoardCommentModel;
import com.ez.teen.board.model.BoardModel;
import com.ez.teen.board.model.BoardParam;
import com.ez.teen.board.model.CommentModel;
import com.ez.teen.board.model.CommentParam;
import com.ez.teen.common.file.FileUtils;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;

	@Autowired
	FileUtils fileUtils;

	// 전체 이용자 수
	@Override
	public int getUserCount() {
		return boardMapper.getUserCount();
	}

	// 전체 게시글 수
	@Override
	public int getBoardCount(BoardParam boardParam) {
		return boardMapper.getBoardCount(boardParam);
	}

	// 전체 댓글 수
	@Override
	public int getCommentCount(CommentParam commentParam) {
		return boardMapper.getCommentCount(commentParam);
	}

	
	// 게시글 수정
	@Override
	public void updateBoard(BoardModel boardModel) {

		boardMapper.updateBoard(boardModel);
	}

	// 게시글 작성
	@Override
	public void insertBoard(BoardModel boardModel, MultipartHttpServletRequest mpRequest) throws Exception {
		
		//받아온 태그 이름이 (java,c,html)으로 들어온다면 쉼표를 해시태그로 변경하면 된다
		String replaceTagName = boardModel.getBoard_tag_name();
		//replace([기존문자],[바꿀문자])
		replaceTagName = replaceTagName.replace(",", " #");
		boardModel.setBoard_tag_name(replaceTagName);
		
		boardMapper.insertBoard(boardModel);

		List<Map<String, Object>> list = fileUtils.parseInsertFileInfo(boardModel, mpRequest);

		int size = list.size();
		if(list != null) {
		for (int i = 0; i < size; i++) {
			boardMapper.insertFile(list.get(i));
			boardMapper.fileCk(boardModel);
		}
	}
}

	// 첨부파일 추가
	@Override
	public void insertFile(Map<String, Object> map) throws Exception {

		boardMapper.insertFile(map);

	}
	//첨부파일 조회
	@Override
	public List<Map<String, Object>> selectFile(int board_no) throws Exception {

		return boardMapper.selectFile(board_no);
	}

	//첨부파일 다운로드
	@Override
	public Map<String, Object> downFile(Map<String, Object> map) throws Exception {

		return boardMapper.downFile(map);
	}

	
	@Override
	public List<BoardModel> boardList(BoardParam boardParam) {
		return boardMapper.boardList(boardParam);
	}

	@Override
	public List<CommentModel> commentList(CommentParam commentParam) {
		return boardMapper.commentList(commentParam);
	}

	// 게시글디테일
	@Override
	public List<BoardModel> selectBoardDetail(BoardParam boardParam) {
		return boardMapper.selectBoardDetail(boardParam);
	}

	// 게시글 디테일 속 댓글
	@Override
	public List<BoardCommentModel> selectComment(BoardParam boardParam) {
		return boardMapper.selectComment(boardParam);
	}
	
	// 게시글 디테일 속 답변
	@Override
	public List<BoardAnswerModel> selectAnswer(BoardParam boardParam) {
		return boardMapper.selectAnswer(boardParam);
	}
	@Override
	public void insertComment(CommentModel commentModel) {
		boardMapper.insertComment(commentModel);
		
	}

	@Override
	public void hitCount(BoardModel boardModel) {
		boardMapper.hitCount(boardModel);
	}

	@Override
	public void recommendBoard(BoardModel boardModel) {
		boardMapper.recommendBoard(boardModel);
	}

	@Override
	public int getRefStep(int board_no) {
		return boardMapper.getRefStep(board_no);
	}

}
