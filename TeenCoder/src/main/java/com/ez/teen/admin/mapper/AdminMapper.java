package com.ez.teen.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ez.teen.member.model.MemberModel;

@Mapper
public interface AdminMapper {

	// 회원 관리
	public MemberModel memberList(MemberModel memberModel) throws Exception;
	
}