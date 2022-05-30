package com.ez.teen.member.service;


import com.ez.teen.member.model.MemberModel;

public interface MemberService {
	
	//회원가입
	public void insertmember(MemberModel model);
	
	// 아이디중복체크
	public int checkId(String member_id);
	
	// 닉네임 중복체크
	public int checkNick(String member_nick);
	
	// 이메일 중복체크
	public int checkEmail(String member_email);
	
	// 회원탈퇴
	public void deletemember(MemberModel memberModel);

	// 회원정보 수정
	public void mypageModify(MemberModel memberModel);
}
