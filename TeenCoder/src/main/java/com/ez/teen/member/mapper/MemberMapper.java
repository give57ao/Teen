package com.ez.teen.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ez.teen.member.model.MemberModel;

@Mapper
public interface MemberMapper {

	
		List<MemberModel> myPageList(MemberModel memberModel) throws Exception;
		
}
