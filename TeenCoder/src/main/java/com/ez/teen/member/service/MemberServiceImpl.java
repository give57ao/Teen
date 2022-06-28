package com.ez.teen.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ez.teen.common.file.FileUtil;
import com.ez.teen.member.mapper.MemberMapper;
import com.ez.teen.member.model.MemberModel;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	

	@Autowired
	FileUtil fileUtils;
	
	// 마이페이지
	@Override
	public List<MemberModel> myPageList(MemberModel memberModel) throws Exception {
		return memberMapper.myPageList(memberModel);
	}

	// 회원가입
	@Override
	public void insertMember(MemberModel memberModel) {
		memberMapper.insertMember(memberModel);
	
	}
	
	// 아이디 중복체크
	@Override
	public int checkId(String member_id) {
		
		int result = memberMapper.checkId(member_id);
		
		return result; 
	}
	
	// 닉네임 중복체크
	@Override
	public int checkNick(String member_nick) {

		int result = memberMapper.checkNick(member_nick);
		
		return result;
	}

	// 회원정보 삭제
	@Override
	public void deleteMember(MemberModel memberModel) {
		memberMapper.deleteMember(memberModel);
	}

	// 회원정보수정
	@Override
	public void mypageModify(MemberModel memberModel){
		
		memberMapper.mypageModify(memberModel);
	}

	@Override public int passChk(MemberModel memberModel){
	 
		int result = memberMapper.passChk(memberModel); 
	    return result; 
	}

	@Override
	public void temPwUpdate(MemberModel memberModel) {
		memberMapper.temPwUpdate(memberModel);
	}

	//프로필 수정
	@Override
	public void profileModifyMember(MemberModel memberModel, MultipartHttpServletRequest mpRequest) throws Exception {
		
		/*
		 * List<Map<String, Object>> list =
		 * fileUtils.parseInsertProFileInfo(memberModel, mpRequest);
		 * 
		 * Map<String, Object> tempMap = null; tempMap = list.get(0); String savedname =
		 * (String)tempMap.get("STORED_FILE_NAME");
		 * memberModel.setMember_profile(savedname);
		 * 
		 * memberMapper.profileModifyMember(memberModel);
		 */
				
			List<Map<String, Object>> list = fileUtils.parseInsertProFileInfo(memberModel, mpRequest); //list가 0임

			int size = list.size();
			if (list != null) {
				for (int i = 0; i < size; i++) {
					String savedname = (String)list.get(i).get("STORED_FILE_NAME");
					memberModel.setMember_profile(savedname);
					memberMapper.profileModifyMember(memberModel);
				}
			}
	
		
	}
	 
}