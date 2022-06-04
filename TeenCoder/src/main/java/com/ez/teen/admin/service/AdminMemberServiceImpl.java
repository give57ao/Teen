package com.ez.teen.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ez.teen.admin.mapper.AdminMapper;
import com.ez.teen.board.model.BoardModel;
import com.ez.teen.member.model.MemberModel;
import com.ez.teen.member.model.MemberParam;

@Service
public class AdminMemberServiceImpl implements AdminMemberService {

	@Autowired
	private AdminMapper adminMapper;
	
	// 전체 회원 수
	@Override
	public int getMemberCount(MemberParam memberParam) {
		return adminMapper.getMemberCount(memberParam);
	}
	
	// 회원관리 리스트
	@Override
	public List<MemberModel> memberList(MemberParam memberParam) throws Exception {
		return adminMapper.memberList(memberParam);
	}
	
	// 회원정보 수정
	@Override
	public List<MemberModel> memberModifyForm(MemberModel memberModel) throws Exception {
		return adminMapper.memberModifyForm(memberModel);
	}
	
	@Override
	public void memberModify(MemberModel memberModel) throws Exception {
		adminMapper.memberModify(memberModel);
	}
	
	// 회원정보 삭제
	@Override
	public void memberDelete(MemberModel memberModel) throws Exception {
		adminMapper.memberDelete(memberModel);
	}

}