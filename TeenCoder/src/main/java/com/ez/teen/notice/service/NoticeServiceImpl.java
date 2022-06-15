package com.ez.teen.notice.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ez.teen.board.model.CommentModel;
import com.ez.teen.board.model.CommentParam;
import com.ez.teen.common.file.FileUtil;
import com.ez.teen.notice.mapper.NoticeMapper;
import com.ez.teen.notice.model.NoticeModel;
import com.ez.teen.notice.model.NoticeParam;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	NoticeMapper noticeMapper;
	
	@Autowired
	FileUtil fileUtils;
	
	@Override
	public int getNoticeCount(NoticeParam noticeParam) {
		return noticeMapper.getNoticeCount(noticeParam);
	}

	@Override
	public List<NoticeModel> noticeList(NoticeParam noticeParam) {
		return noticeMapper.noticeList(noticeParam);
	}
	
	//공지사항 작성
	@Override
	public void insertNotice(NoticeModel noticeModel, MultipartHttpServletRequest mpRequest) throws Exception {
	
		noticeMapper.insertNotice(noticeModel);
		
		List<Map<String, Object>> list = fileUtils.parseInsertnoticeFileInfo(noticeModel, mpRequest);
			
		int size = list.size();
		if(list != null) {
			for(int i = 0; i < size; i++) {
				noticeMapper.insertNotiFile(list.get(i));
				noticeMapper.NotifileCk(noticeModel);
			}
		}
	}

	// 첨부파일 조회
	@Override
	public List<Map<String, Object>> selectNotiFile(int noti_no) throws Exception {

		return noticeMapper.selectNotiFile(noti_no);
	}

	@Override
	public void insertNotiFile(Map<String, Object> map) throws Exception {
		
		noticeMapper.insertNotiFile(map);
	}

	//댓글 리스트 불러오기
	@Override
	public List<CommentModel> reportCmtList(CommentParam cmtParam) {

		return noticeMapper.reportCmtList(cmtParam);
	}

	@Override
	public void deleteCmt(CommentModel cmtModel)throws Exception {
		
		noticeMapper.deleteCmt(cmtModel);
	}
	
	
	
	
	

}
