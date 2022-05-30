package com.ez.teen.member.mapper;



import org.apache.ibatis.annotations.Mapper;
import com.ez.teen.member.model.MemberModel;

@Mapper
public interface MemberMapper {
	
	// 회원가입
	void insertMember(MemberModel model);
	
	// 아이디 중복체크
	int checkId(String member_id);
	
	// 닉네임 중복체크
	int checkNick(String member_nick);
	
	// 이메일 중복체크
	int checkEmail(String member_email);
	
	// 회원 탈퇴
	void deleteMember(MemberModel memberModel);
	
	// 내정보 수정
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
		
		//마이페이지 홈
		MemberModel myPage(MemberModel memberModel) throws Exception;
}
