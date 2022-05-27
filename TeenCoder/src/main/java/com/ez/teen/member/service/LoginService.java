package com.ez.teen.member.service;

import java.util.List;

import com.ez.teen.member.model.MemberModel;

public interface LoginService {

	MemberModel login(MemberModel memberModel) throws Exception;
	
	MemberModel loginCheck(MemberModel memberModel) throws Exception;
	
	MemberModel findId(MemberModel memberModel)throws Exception;
	
	MemberModel findPw(MemberModel memberModel)throws Exception;
	
	MemberModel test(MemberModel memberModel)throws Exception;
	

	
	
}
