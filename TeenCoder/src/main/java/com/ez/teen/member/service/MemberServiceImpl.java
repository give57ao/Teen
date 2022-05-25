package com.ez.teen.member.service;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.ez.teen.member.mapper.MemberMapper;
import com.ez.teen.member.model.MemberModel;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberMapper memberMapper;

	@Override
	public void insertMember(MemberModel model) {
		
		memberMapper.insertMember(model);
		
	}

	@Override
	public int checkId(String member_id) {
		
		int result = memberMapper.checkId(member_id);
		
		return result; 
	}

	@Override
	public int checkNick(String member_nick) {

		int result = memberMapper.checkNick(member_nick);
		
		return result;
	}

	@Override
	public int checkEmail(String member_email) {

		int result = memberMapper.checkEmail(member_email);
		
		return result;
	}

	@Override
	public void deleteMember(MemberModel model) {
		
		memberMapper.deleteMember(model);
		
	}

}