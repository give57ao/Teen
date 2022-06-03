package com.ez.teen.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ez.teen.member.model.MemberModel;
import com.ez.teen.member.model.MemberParam;

@Mapper
public interface AdminMapper {

	// 전체 회원 수
	public int getMemberCount(MemberParam memberParam);
	
	// 회원 리스트
	public List<MemberModel> memberList(MemberParam memberParam) throws Exception;
	
	// 회원정보 수정
	public void memberModify(MemberModel memberModel) throws Exception;
	
	// 회원정보 삭제
	public void memberDelete(MemberModel memberModel) throws Exception;

}