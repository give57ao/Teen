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
	
	//마이페이지
	@Override
	public List<MemberModel> myPageList(MemberModel memberModel) throws Exception {
		return memberMapper.myPageList(memberModel);
	}

	//회원가입
	@Override
	public void insertMember(MemberModel memberModel) {
		memberMapper.insertMember(memberModel);
	
	}
	
	//아이디 중복체크
	@Override
	public int checkId(MemberModel memberModel) {
		
		int result = memberMapper.checkId(memberModel);
		
		return result; 
	}
	
	// 닉네임 중복체크
	@Override
	public int checkNick(MemberModel memberModel) {

		int result = memberMapper.checkNick(memberModel);
		
		return result;
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


	
	
	

	



