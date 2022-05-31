 package com.ez.teen.board.model;

import java.util.Date;

public class BoardCommentModel {
	
	private int bcomment_no;
	private int board_no;
	private int board_group_no;
	private String bcomment_content;
	private Date bcomment_date;
	private int member_no;
	private int bcomment_report_count;
	private int bcomment_like_count;;
	private int ref_no;
	private int ref_step;
	private int ref_level;
	
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
	public int getRef_no() {
		return ref_no;
	}
	public void setRef_no(int ref_no) {
		this.ref_no = ref_no;
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
