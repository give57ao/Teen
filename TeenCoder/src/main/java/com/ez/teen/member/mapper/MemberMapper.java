package com.ez.teen.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ez.teen.member.model.MemberModel;

@Mapper
public interface MemberMapper {

	public List<MemberModel> myPageList(MemberModel memberModel) throws Exception;

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
	
	public void insertMember(MemberModel model);
	
	public void deleteMember(MemberModel model);

	public void mypageModify(MemberModel memberModel);


}
