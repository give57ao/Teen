package com.ez.teen.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ez.teen.member.model.MemberModel;

@Mapper
public interface MemberMapper {

	List<MemberModel> myPageList(MemberModel memberModel) throws Exception;

	// 로그인
	MemberModel login(MemberModel memberModel) throws Exception;
	
	// 로그인 체크
	MemberModel loginCheck(MemberModel memberModel) throws Exception;
	
	// 로그아웃
	MemberModel logout(MemberModel memberModel) throws Exception;
	
	// 아이디 찾기
	MemberModel findId(MemberModel memberModel) throws Exception;
	
	// 비밀번호 찾기
	MemberModel findPw(MemberModel memberModel) throws Exception;
	
	void insertMember(MemberModel model);
	
	int checkId(String memberId);
	
	int checkNick(String memberNick);
	
	int checkEmail(String memberEmail);
	
	void deleteMember(MemberModel model);

	void mypageModify(MemberModel memberModel);
	/*
	 * MemberModel login(MemberModel memberModel) throws Exception;
	 * 
	 * MemberModel loginCheck(MemberModel memberModel) throws Exception;
	 * 
	 * MemberModel findId(MemberModel memberModel) throws Exception;
	 * 
	 * MemberModel findPw(MemberModel memberModel) throws Exception;
	 * 
	 * MemberModel test(MemberModel memberModel) throws Exception;
	 * 
	 * MemberModel findMemberName(List<MemberModel> memberModel);
	 * 
	 * MemberModel findMemberEmail(List<MemberModel> memberModel);
	 * 
	 * MemberModel findMemberId(List<MemberModel> memberModel);
	 * 
	 * MemberModel myPage(MemberModel memberModel) throws Exception;
	 */

}
