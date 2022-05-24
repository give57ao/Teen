package com.ez.teen.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ez.teen.member.mapper.MemberMapper;
import com.ez.teen.member.model.MemberModel;

@Service
public class loginServiceImpl implements loginService{
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public MemberModel login(MemberModel memberModel) throws Exception {
		return memberMapper.login(memberModel);
	}

	@Override
	public MemberModel loginCheck(MemberModel memberModel) throws Exception {
		return memberMapper.loginCheck(memberModel);
	}

	@Override
	public MemberModel findId(MemberModel memberModel) throws Exception {
		return memberMapper.findId(memberModel);
	}

	@Override
	public MemberModel findPw(MemberModel memberModel) throws Exception {
		return memberMapper.findPw(memberModel);
	}

	
	

}
