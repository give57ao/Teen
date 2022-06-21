package com.ez.teen.board.service;

import java.util.HashMap;
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
import com.ez.teen.common.file.FileUtil;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;

	@Autowired
	FileUtil fileUtils;

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
	public void updateBoard(BoardModel boardModel, String[] files, String[] fileNames,
			MultipartHttpServletRequest mpRequest) throws Exception {

		String replaceTagName = boardModel.getBoard_tag_name();
		replaceTagName = replaceTagName.replace(",", " #");
		boardModel.setBoard_tag_name(replaceTagName);

		boardMapper.updateBoard(boardModel);

		List<Map<String, Object>> list = fileUtils.parseUpdateFileInfo(boardModel, files, fileNames, mpRequest);
		Map<String, Object> tempMap = null;
		int size = list.size();
		for (int i = 0; i < size; i++) {
			tempMap = list.get(i);
			if (tempMap.get("NEW_FILE").equals("Y")) {
				boardMapper.insertFile(tempMap);
			} else {
				boardMapper.updateFile(tempMap);
			}
		}

	}

	//댓글 수정
	@Override
	public void modifyComment(CommentModel commentModel, String[] files, String[] fileNames,
			MultipartHttpServletRequest mpRequest) throws Exception {
		boardMapper.modifyComment(commentModel);
		
		System.out.println("====================" + files + "============" + fileNames);
		List<Map<String, Object>> list = fileUtils.parseUpdateCommentFileInfo(commentModel, files, fileNames, mpRequest);
		Map<String, Object> tempMap = null;
		int size = list.size();
		for (int i = 0; i < size; i++) {
			tempMap = list.get(i);
			if (tempMap.get("NEW_FILE").equals("Y")) {
				
				commentModel.setOrg_file_name((String)tempMap.get("ORG_FILE_NAME"));
				commentModel.setStored_file_name((String)tempMap.get("STORED_FILE_NAME"));
				commentModel.setFile_size(123);
				
				System.out.println("=========== COMMENT MODEL :"  + commentModel);
				
				boardMapper.updateCmtFile(commentModel);
			} 
			else {
				boardMapper.updateFile(tempMap);
			}
		}
		

		
	}
	
	// 게시글 작성
	@Override
	public void insertBoard(BoardModel boardModel, MultipartHttpServletRequest mpRequest) throws Exception {

		// 받아온 태그 이름이 (java,c,html)으로 들어온다면 쉼표를 해시태그로 변경하면 된다
		String replaceTagName = boardModel.getBoard_tag_name();
		// replace([기존문자],[바꿀문자])
		replaceTagName = replaceTagName.replace(",", " #");
		boardModel.setBoard_tag_name(replaceTagName);

		boardMapper.insertBoard(boardModel);

		List<Map<String, Object>> list = fileUtils.parseInsertFileInfo(boardModel, mpRequest);

		int size = list.size();
		if (list != null) {
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

	// 첨부파일 조회
	@Override
	public List<Map<String, Object>> selectFile(int board_no) throws Exception {

		return boardMapper.selectFile(board_no);
	}

	// 첨부파일 다운로드
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

	// 댓글 작성
	@Override
	public void insertComment(CommentModel commentModel, MultipartHttpServletRequest mpRequest) throws Exception {

		boardMapper.insertComment(commentModel);

		List<Map<String, Object>> list = fileUtils.parseInsertCmtFileInfo(commentModel, mpRequest);

		int size = list.size();
		for (int i = 0; i < size; i++) {
			boardMapper.insertCmtFile(list.get(i));

		}
	}

	@Override
	public void hitCount(BoardModel boardModel) {
		boardMapper.hitCount(boardModel);
	}

	@Override
	public void recommendBoard(BoardModel boardModel) {
		boardMapper.recommendBoard(boardModel);
	}

	// 댓글 작성 전 순서 검사
	@Override
	public int getRefStep(int board_no) {
		return boardMapper.getRefStep(board_no);
	}

	// 답글 작성 전 순서 검사
	@Override
	public int getRefLevel(CommentParam commentParam) {
		return boardMapper.getRefLevel(commentParam);
	}

	@Override
	public void insertReComment(CommentModel commentModel) {
		boardMapper.insertReComment(commentModel);
	}

	@Override
	public void insertSummerNote(String fileName) {
		boardMapper.insertSummerNote(fileName);
	}

	@Override
	public void updateTagName(BoardModel boardModel) {
		boardMapper.updateTagName(boardModel);
	}

	@Override
	public void deleteBoard(int board_no) {
		boardMapper.deleteBoard(board_no);

	}

	// 댓글 첨부파일 추가
	@Override
	public void insertCmtFile(Map<String, Object> map) throws Exception {

		boardMapper.insertCmtFile(map);

	}

	@Override
	public void deleteBcomment(int bcomment_no) {
		boardMapper.deleteBcomment(bcomment_no);
	}

	// detail내 댓글개수
	@Override
	public int commentCount(int board_no) {
		return boardMapper.commentCount(board_no);
	}

	// detail내 답글개수
	@Override
	public List<BoardAnswerModel> answerCount(BoardParam boardParam) {
		return boardMapper.answerCount(boardParam);
	}

	@Override
	public int getBoardLike(BoardParam boardParam) throws Exception {
		return boardMapper.getBoardLike(boardParam);
	}

	@Override
	public void insertBoardLike(BoardModel boardModel) throws Exception {
			boardMapper.insertBoardLike(boardModel);
			boardMapper.updateBoardLike(boardModel.getBoard_no());
		
	}

	@Override
	public void deleteBoardLike(BoardModel boardModel) throws Exception {
		boardMapper.deleteBoardLike(boardModel);
		boardMapper.updateBoardLike(boardModel.getBoard_no());
		
	}

	@Override
	public int getBoardReport(BoardParam boardParam) throws Exception {
		return boardMapper.getBoardReport(boardParam);
	}

	@Override
	public void insertBoardReport(BoardModel boardModel) throws Exception {
			boardMapper.insertBoardReport(boardModel);
			boardMapper.updateBoardReport(boardModel.getBoard_no());
	}

	@Override
	public void deleteBoardReport(BoardModel boardModel) throws Exception {
		boardMapper.deleteBoardReport(boardModel);
		boardMapper.updateBoardReport(boardModel.getBoard_no());
	}


}