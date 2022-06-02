package com.ez.teen.admin.service;

import com.ez.teen.member.model.MemberModel;

public interface AdminMemberService {
	
	// 회원 관리
	public MemberModel memberList(MemberModel memberModel) throws Exception;
	
}