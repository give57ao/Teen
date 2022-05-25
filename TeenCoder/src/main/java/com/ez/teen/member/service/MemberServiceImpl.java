package com.ez.teen.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ez.teen.member.mapper.MemberMapper;
import com.ez.teen.member.model.MemberModel;

@Service
public class MemberServiceImpl  implements MemberService{
	
	@Autowired
	MemberMapper memberMapper;

	@Override
	public List<MemberModel> myPageList(MemberModel memberModel) throws Exception {
		return memberMapper.myPageList(memberModel);
	}
	
	

}
