package com.ez.teen.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ez.teen.admin.mapper.AdminMapper;
import com.ez.teen.member.model.MemberModel;

@Service
public class AdminMemberServiceImpl implements AdminMemberService {

	@Autowired
	private AdminMapper adminMapper;
	
	// 회원 리스트
	@Override
	public MemberModel memberList(MemberModel memberModel) throws Exception {
		return adminMapper.memberList(memberModel);
	}
	
	// 회원정보 수정
	@Override
	public MemberModel memberModify(MemberModel memberModel) throws Exception {
		return adminMapper.memberModify(memberModel);
	}
	
	// 회원정보 삭제
	@Override
	public MemberModel memberDelete(MemberModel memberModel) throws Exception {
		return adminMapper.memberDelete(memberModel);
	}
	
}