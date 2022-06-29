package com.ez.teen.member.model;

import java.util.Date;

public class MemberCardModel {

	private int member_no; // 회원 고유 번호
	private String member_id; // 회원 아이디
	private String member_pw; // 비밀번호
	private String temPw;


	private String member_name; // 회원 이름
	private String member_email; // 회원 이메일
	private String member_email_check; // 회원 이메일 체크
	private String member_nick; // 회원 닉네임
	private String member_admin; // 관리자 확인
	private Date member_date; // 회원가입 날짜
	private String member_pro_check; // 전문가 유무 확인,
	private Integer member_point; // 멤버 포인트
	
	private int board_no;
	private String board_title;
	private Date board_date;
	private String board_group_no;
	private String board_tag_name;
	
	
	private int scrap_no;
	private Date scrap_date;
	
	private int follow_no;
	private int following_member_no;
	private Date follow_date;
	
	private int bcomment_no;
	private String bcomment_content;
	private int ref_step;

	

	
	public String getBoard_group_no() {
		return board_group_no;
	}
	public void setBoard_group_no(String board_group_no) {
		this.board_group_no = board_group_no;
	}
	public String getBoard_tag_name() {
		return board_tag_name;
	}
	public void setBoard_tag_name(String board_tag_name) {
		this.board_tag_name = board_tag_name;
	}
	public int getBcomment_no() {
		return bcomment_no;
	}
	public void setBcomment_no(int bcomment_no) {
		this.bcomment_no = bcomment_no;
	}
	public String getBcomment_content() {
		return bcomment_content;
	}
	public void setBcomment_content(String bcomment_content) {
		this.bcomment_content = bcomment_content;
	}
	public int getRef_step() {
		return ref_step;
	}
	public void setRef_step(int ref_step) {
		this.ref_step = ref_step;
	}
	public int getFollowing_member_no() {
		return following_member_no;
	}
	public void setFollowing_member_no(int following_member_no) {
		this.following_member_no = following_member_no;
	}
	public int getFollow_no() {
		return follow_no;
	}
	public void setFollow_no(int follow_no) {
		this.follow_no = follow_no;
	}
	public Date getFollow_date() {
		return follow_date;
	}
	public void setFollow_date(Date follow_date) {
		this.follow_date = follow_date;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
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
	public String getTemPw() {
		return temPw;
	}
	public void setTemPw(String temPw) {
		this.temPw = temPw;
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
	public String getMember_email_check() {
		return member_email_check;
	}
	public void setMember_email_check(String member_email_check) {
		this.member_email_check = member_email_check;
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
	public String getMember_pro_check() {
		return member_pro_check;
	}
	public void setMember_pro_check(String member_pro_check) {
		this.member_pro_check = member_pro_check;
	}
	public Integer getMember_point() {
		return member_point;
	}
	public void setMember_point(Integer member_point) {
		this.member_point = member_point;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public Date getBoard_date() {
		return board_date;
	}
	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}
	public int getScrap_no() {
		return scrap_no;
	}
	public void setScrap_no(int scrap_no) {
		this.scrap_no = scrap_no;
	}
	public Date getScrap_date() {
		return scrap_date;
	}
	public void setScrap_date(Date scrap_date) {
		this.scrap_date = scrap_date;
	}
	
	
	
	
	
}
