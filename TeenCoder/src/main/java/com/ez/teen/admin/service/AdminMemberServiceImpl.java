package com.ez.teen.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ez.teen.admin.mapper.AdminMapper;
import com.ez.teen.member.model.MemberModel;

@Service
public class AdminMemberServiceImpl implements AdminMemberService {

	@Autowired
	private AdminMapper adminMapper;
	
	// 회원 관리
	@Override
	public MemberModel memberList(MemberModel memberModel) throws Exception {
		return adminMapper.memberList(memberModel);
	}
	
}