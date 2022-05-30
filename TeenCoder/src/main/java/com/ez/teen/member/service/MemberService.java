package com.ez.teen.member.service;

import java.util.List;

import com.ez.teen.member.model.MemberModel;

public interface MemberService {
	
	public List<MemberModel> myPageList(MemberModel memberModel) throws Exception;

	public int checkId(String member_id);
	
	public int checkNick(String member_nick);
	
	public int checkEmail(String member_email);
	
	public void deleteMember(MemberModel memberModel);
	
	public void insertMember(MemberModel memberModel);
	
	public void mypageModify(MemberModel memberModel);

}