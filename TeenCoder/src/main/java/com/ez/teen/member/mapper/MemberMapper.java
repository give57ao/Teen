package com.ez.teen.member.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ez.teen.member.service.LoginService;
import com.ez.teen.member.model.MemberModel;

@Mapper
public interface MemberMapper {
	
	MemberModel login(MemberModel memberModel) throws Exception;
	
	MemberModel loginCheck(MemberModel memberModel) throws  Exception;
	
	MemberModel findId(MemberModel memberModel) throws Exception;
	
	MemberModel findPw(MemberModel memberModel) throws Exception;
	
	MemberModel test(MemberModel memberModel) throws Exception;

	List<String> findMemberName(MemberModel memberModel);

	List<String> findMemberEmail(MemberModel memberModel);

	List<String> findMemberId(MemberModel memberModel);
	
	
	
	
}
