
package com.ez.teen.member.service;

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
	
	// 마이페이지
	MemberModel myPageModify(MemberModel memberModel)throws Exception;
}


package com.ez.teen.member.service;

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
	
	// 마이페이지
	MemberModel myPageModify(MemberModel memberModel)throws Exception;
}
