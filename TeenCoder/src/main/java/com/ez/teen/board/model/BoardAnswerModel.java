package com.ez.teen.board.model;

import java.util.Date;

public class BoardAnswerModel {
	//push용 추가 멘트
	private int bcomment_no;
	private int board_no;
	private int board_group_no;
	private String bcomment_content;
	private Date bcomment_date;
	private int member_no;
	private String member_nick;
	private int bcomment_report_count;
	private int bcomment_like_count;;
	private int ref_step;
	private int ref_level;
	private int board_answer_count; // 갯수 카운트용 변수 선언
	
	public int getBoard_answer_count() {
		return board_answer_count;
	}

	public void setBoard_answer_count(int board_answer_count) {
		this.board_answer_count = board_answer_count;
	}

	public String getMember_nick() {
		return member_nick;
	}

	public void setMember_nick(String member_nick) {
		this.member_nick = member_nick;
	}

	public int getBcomment_no() {
		return bcomment_no;
	}

	public void setBcomment_no(int bcomment_no) {
		this.bcomment_no = bcomment_no;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public int getBoard_group_no() {
		return board_group_no;
	}

	public void setBoard_group_no(int board_group_no) {
		this.board_group_no = board_group_no;
	}

	public String getBcomment_content() {
		return bcomment_content;
	}

	public void setBcomment_content(String bcomment_content) {
		this.bcomment_content = bcomment_content;
	}

	public Date getBcomment_date() {
		return bcomment_date;
	}

	public void setBcomment_date(Date bcomment_date) {
		this.bcomment_date = bcomment_date;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public int getBcomment_report_count() {
		return bcomment_report_count;
	}

	public void setBcomment_report_count(int bcomment_report_count) {
		this.bcomment_report_count = bcomment_report_count;
	}

	public int getBcomment_like_count() {
		return bcomment_like_count;
	}

	public void setBcomment_like_count(int bcomment_like_count) {
		this.bcomment_like_count = bcomment_like_count;
	}

	public int getRef_step() {
		return ref_step;
	}

	public void setRef_step(int ref_step) {
		this.ref_step = ref_step;
	}

	public int getRef_level() {
		return ref_level;
	}

	public void setRef_level(int ref_level) {
		this.ref_level = ref_level;
	}
}
