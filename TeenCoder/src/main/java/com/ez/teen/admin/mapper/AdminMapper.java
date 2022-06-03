package com.ez.teen.admin.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ez.teen.member.model.MemberModel;

@Mapper
public interface AdminMapper {

	// 회원 리스트
	public MemberModel memberList(MemberModel memberModel) throws Exception;
	
	// 회원정보 수정
	public MemberModel memberModify(MemberModel memberModel) throws Exception;
	
	// 회원정보 삭제
	public MemberModel memberDelete(MemberModel memberModel) throws Exception;
	
}