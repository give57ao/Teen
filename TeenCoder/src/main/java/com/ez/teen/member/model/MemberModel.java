package com.ez.teen.member.model;

import java.util.Date;

public class MemberModel {

	private int memberNo; // 회원 고유 번호
	private String memberId; // 회원 아이디
	private String memberPw; // 비밀번호
	private String memberName; // 회원 이름
	private String memberEmail; // 회원 이메일
	private String memberEmailCheck; // 회원 이메일 체크
	private String memberNick; // 회원 닉네임
	private String memberAdmin; // 관리자 확인
	private Date memberDate; // 회원가입 날짜
	private String memberProCheck; // 전문가 유무 확인,
	private int memberPoint; // 멤버 포인트
	
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberEmailCheck() {
		return memberEmailCheck;
	}
	public void setMemberEmailCheck(String memberEmailCheck) {
		this.memberEmailCheck = memberEmailCheck;
	}
	public String getMemberNick() {
		return memberNick;
	}
	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}
	public String getMemberAdmin() {
		return memberAdmin;
	}
	public void setMemberAdmin(String memberAdmin) {
		this.memberAdmin = memberAdmin;
	}
	public Date getMemberDate() {
		return memberDate;
	}
	public void setMemberDate(Date memberDate) {
		this.memberDate = memberDate;
	}
	public String getMemberProCheck() {
		return memberProCheck;
	}
	public void setMemberProCheck(String memberProCheck) {
		this.memberProCheck = memberProCheck;
	}
	public int getMemberPoint() {
		return memberPoint;
	}
	public void setMemberPoint(int memberPoint) {
		this.memberPoint = memberPoint;
	}
	

	@Override
	public String toString() {
		return "MemberModel [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPw=" + memberPw
				+ ", memberName=" + memberName + ", memberEmail=" + memberEmail + ", memberEmailCheck="
				+ memberEmailCheck + ", memberNick=" + memberNick + ", memberAdmin=" + memberAdmin + ", memberDate="
				+ memberDate + ", memberProCheck=" + memberProCheck + ", memberPoint=" + memberPoint + "]";
	}
	
}
