package com.ez.teen.member.model;

import java.util.Date;

public class MemberModel {
	
	private String MEMBER_ID;
	private String MEMBER_PW;
	private String MEMBER_EMAIL;
	private String MEMBER_NAME;
	
	public String getMEMBER_ID() {
		return MEMBER_ID;
	}
	public void setMEMBER_ID(String mEMBER_ID) {
		MEMBER_ID = mEMBER_ID;
	}
	public String getMEMBER_PW() {
		return MEMBER_PW;
	}
	public void setMEMBER_PW(String mEMBER_PW) {
		MEMBER_PW = mEMBER_PW;
	}
	public String getMEMBER_EMAIL() {
		return MEMBER_EMAIL;
	}
	public void setMEMBER_EMAIL(String mEMBER_EMAIL) {
		MEMBER_EMAIL = mEMBER_EMAIL;
	}
	public String getMEMBER_NAME() {
		return MEMBER_NAME;
	}
	public void setMEMBER_NAME(String mEMBER_NAME) {
		MEMBER_NAME = mEMBER_NAME;
	}
	

	private int member_no; // 회원 고유 번호
	private String member_id; // 회원 아이디
	private String member_pw; // 비밀번호
	private String member_name; // 회원 이름
	private String member_email; // 회원 이메일
	private String member_emailcheck; // 회원 이메일 체크
	private String member_nick; // 회원 닉네임
	private String member_admin; // 관리자 확인
	private Date member_date; // 회원가입 날짜
	private String member_procheck; // 전문가 유무 확인,
	private Integer member_point; // 멤버 포인트
	
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(Integer member_no) {
		this.member_no = member_no;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_pw() {
		return member_pw;
	}
	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public String getMember_emailcheck() {
		return member_emailcheck;
	}
	public void setMember_emailcheck(String member_emailcheck) {
		this.member_emailcheck = member_emailcheck;
	}
	public String getMember_nick() {
		return member_nick;
	}
	public void setMember_nick(String member_nick) {
		this.member_nick = member_nick;
	}
	public String getMember_admin() {
		return member_admin;
	}
	public void setMember_admin(String member_admin) {
		this.member_admin = member_admin;
	}
	public Date getMember_date() {
		return member_date;
	}
	public void setMember_date(Date member_date) {
		this.member_date = member_date;
	}
	public String getMember_procheck() {
		return member_procheck;
	}
	public void setMember_procheck(String member_procheck) {
		this.member_procheck = member_procheck;
	}
	public Integer getMember_point() {
		return member_point;
	}
	public void setMember_point(Integer member_point) {
		this.member_point = member_point;
	}
	
	@Override
	public String toString() {
		return "MemberModel [member_no=" + member_no + ", member_id=" + member_id + ", member_pw=" + member_pw
				+ ", member_name=" + member_name + ", member_email=" + member_email + ", member_emailcheck="
				+ member_emailcheck + ", member_nick=" + member_nick + ", member_admin=" + member_admin
				+ ", member_date=" + member_date + ", member_procheck=" + member_procheck + ", member_point="
				+ member_point + "]";
	}

}

