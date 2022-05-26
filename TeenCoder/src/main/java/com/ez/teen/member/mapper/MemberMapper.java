package com.ez.teen.member.mapper;



import org.apache.ibatis.annotations.Mapper;
import com.ez.teen.member.model.MemberModel;

@Mapper
public interface MemberMapper {
	

	void insertMember(MemberModel model);
	
	int checkId(String member_id);
	
	int checkNick(String member_nick);
	
	int checkEmail(String member_email);
	
	void deleteMember(MemberModel memberModel);
	
	void mypageModify(MemberModel memberModel);
	
	// 로그인
		MemberModel login(MemberModel memberModel) throws Exception;
		
		// 로그인 체크
		MemberModel loginCheck(MemberModel memberModel) throws Exception;
		
		// 로그아웃
		MemberModel logout(MemberModel memberModel) throws Exception;
		
		// 아이디 찾기
		MemberModel findId(MemberModel memberModel) throws Exception;
		
		// 비밀번호 찾기
		MemberModel findPw(MemberModel memberModel) throws Exception;
		
		MemberModel myPage(MemberModel memberModel) throws Exception;
}
