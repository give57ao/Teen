package com.ez.teen.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ez.teen.member.mapper.MemberMapper;
import com.ez.teen.member.model.MemberModel;

@Service
public class LoginServiceImpl implements LoginService{
	
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

	@Override
	public MemberModel test(MemberModel memberModel) throws Exception {
		return memberMapper.test(memberModel);
	}

	@Override
	public List<String> findMemberId(MemberModel memberModel) throws Exception {
		return memberMapper.findMemberId(memberModel);
	}

	@Override
	public List<String> findMemberEmail(MemberModel memberModel) throws Exception {
		return memberMapper.findMemberEmail(memberModel);
	}

	@Override
	public List<String> findMemberName(MemberModel memberModel) throws Exception {
		return memberMapper.findMemberName(memberModel);
	}

	

	
	

}
