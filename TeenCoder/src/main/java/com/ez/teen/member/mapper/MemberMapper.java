package com.ez.teen.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ez.teen.member.model.MemberModel;

@Mapper
public interface MemberMapper {

	// 로그인
	public MemberModel login(MemberModel memberModel) throws Exception;
	
	// 로그인 체크
	public MemberModel loginCheck(MemberModel memberModel) throws Exception;
	
	// 로그아웃
	public MemberModel logout(MemberModel memberModel) throws Exception;
	
	// 아이디 찾기
	public MemberModel findId(MemberModel memberModel) throws Exception;
	
	// 비밀번호 찾기
	public MemberModel findPw(MemberModel memberModel) throws Exception;

	//마이페이지
	public List<MemberModel> myPageList(MemberModel memberModel) throws Exception;


	
	// 회원가입
	void insertMember(MemberModel memberModel);
	
	// 아이디 중복체크
	int checkId(MemberModel memberModel);
	
	// 닉네임 중복체크
	int checkNick(MemberModel memberModel);
	
	// 회원 탈퇴
	void deleteMember(MemberModel memberModel);
	
	// 내정보 수정
	void mypageModify(MemberModel memberModel);

	public int passChk(MemberModel memberModel);	
}

