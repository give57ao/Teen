package com.ez.teen.member.service;

import java.util.List;
import java.util.Map;

import com.ez.teen.member.model.MemberModel;

public interface LoginService {
	
	// 로그인
	MemberModel login(MemberModel memberModel) throws Exception;
	
	// 로그인 체크
	MemberModel loginCheck(MemberModel memberModel) throws Exception;
	
	// 로그아웃
	MemberModel logout(MemberModel memberModel) throws Exception;
	
	// 아이디 찾기
	MemberModel findId(MemberModel memberModel)throws Exception;
	
	// 비밀번호 찾기
	MemberModel findPw(MemberModel memberModel)throws Exception;
	
}