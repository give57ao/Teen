
package com.ez.teen.member.service;

import com.ez.teen.member.model.MemberModel;

public interface LoginService {

	public MemberModel login(MemberModel memberModel) throws Exception;

	public MemberModel loginCheck(MemberModel memberModel) throws Exception;

	public MemberModel logout(MemberModel memberModel) throws Exception;

	public MemberModel findId(MemberModel memberModel) throws Exception;

	public MemberModel findPw(MemberModel memberModel) throws Exception;

	public MemberModel myPageModify(MemberModel memberModel) throws Exception;
	
}
