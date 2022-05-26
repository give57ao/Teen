package com.ez.teen.member.service;


import com.ez.teen.member.model.MemberModel;

public interface MemberService {
	
	void insertmember(MemberModel model);
	
	int checkId(String member_id);
	
	int checkNick(String member_nick);
	
	int checkEmail(String member_email);
	
	void deletemember(MemberModel memberModel);

	void mypageModify(MemberModel memberModel);
}
