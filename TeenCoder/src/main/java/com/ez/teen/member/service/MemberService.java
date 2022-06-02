package com.ez.teen.member.service;

import java.util.List;

import com.ez.teen.member.model.MemberModel;

public interface MemberService {
	
	//마이페이지
	public List<MemberModel> myPageList(MemberModel memberModel) throws Exception;

	//회원탈퇴
	public void deleteMember(MemberModel memberModel);

	//회원가입
	public void insertMember(MemberModel memberModel);

	// 아이디중복체크
	public int checkId(MemberModel memberModel);
	
	// 닉네임 중복체크
	public int checkNick(MemberModel memberModel);
	
	// 회원정보 수정
	public void mypageModify(MemberModel memberModel);
	
	
}

