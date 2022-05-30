package com.ez.teen.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ez.teen.member.mapper.MemberMapper;
import com.ez.teen.member.model.MemberModel;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public List<MemberModel> myPageList(MemberModel memberModel) throws Exception {
		return memberMapper.myPageList(memberModel);
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
	public void insertMember(MemberModel memberModel) {
		memberMapper.insertMember(memberModel);
	
	}
	
	//회원정보 삭제
	@Override
	public void deleteMember(MemberModel memberModel) {
		memberMapper.deleteMember(memberModel);
	}

	// 회원정보수정
	@Override
	public void mypageModify(MemberModel memberModel){
		
		memberMapper.mypageModify(memberModel);
	}	
}