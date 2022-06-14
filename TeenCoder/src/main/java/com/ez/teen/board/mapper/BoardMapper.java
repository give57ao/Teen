package com.ez.teen.board.mapper;

//asdf
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

	// �쟾泥� �씠�슜�옄 �닔
	public int getUserCount();

	//�쟾泥� 寃뚯떆湲� �닔
	public int getBoardCount(BoardParam boardParam);
	
	// �쟾泥� �뙎湲� �닔
	public int getCommentCount(CommentParam commentParam);

	// 寃뚯떆湲� 由ъ뒪�듃 (BGROUP 援щ퀎 �뾾�씠)
	public List<BoardModel> boardList(BoardParam boardParam);
	
	// �뙎湲� 由ъ뒪�듃
	public List<CommentModel> commentList(CommentParam commentParam);
		
	// 寃뚯떆湲� �닔�젙
	public void updateBoard(BoardModel boardModel);

	// 寃뚯떆湲� �뵒�뀒�씪 
	public List<BoardModel> selectBoardDetail(BoardParam boardParam);

	// 寃뚯떆湲� �뵒�뀒�씪 �냽 �뙎湲�
	public List<BoardCommentModel> selectComment(BoardParam boardParam);
	
	// 寃뚯떆湲� �뵒�뀒�씪 �냽 �떟湲�
	public List<BoardAnswerModel> selectAnswer(BoardParam boardParam);

	//寃뚯떆湲� �옉�꽦
	public void insertBoard(BoardModel boardModel) throws Exception;
	
	//泥⑤��뙆�씪 �뾽濡쒕뱶
	public void insertFile(Map<String, Object> map) throws Exception;
	
	//泥⑤��뙆�씪 議고쉶
	public List<Map<String, Object>>selectFile(int board_no) throws Exception;
		
	//泥⑤��뙆�씪 �떎�슫濡쒕뱶
	public Map<String, Object> downFile(Map<String, Object> map) throws Exception;
	
	//泥⑤��뙆�씪 �닔�젙
	public void updateFile(Map<String, Object> map) throws Exception;

	//�뙎湲� �옉�꽦
	public void insertComment(CommentModel commentModel);
	
	//議고쉶�닔 利앷�
	public void hitCount(BoardModel boardModel);
	
	//異붿쿇�닔 利앷�
	public void recommendBoard(BoardModel boardModel);

	public void fileCk(BoardModel boardModel);

	public int getRefStep(int board_no);

	public int getRefLevel(CommentParam commentParam);
	
	//�떟湲� �옉�꽦
	public void insertReComment(CommentModel commentModel);

	public void insertSummerNote(String fileName);
	
	public void updateTagName(BoardModel boardModel);
	
	public void deleteBoard(int board_no);
	
}
