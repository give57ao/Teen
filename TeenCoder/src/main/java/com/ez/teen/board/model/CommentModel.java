package com.ez.teen.board.model;

import java.util.Date;

public class CommentModel {
	
	private int bcomment_no;
	private int board_no;
	private String bcomment_content;
	private Date bcomment_date;
	private int member_no;
	private int bcomment_report_count;
	private int bcomment_like_count;
	private int ref_step;
	private int ref_level;
	private String member_nick;
	private String board_title;
	private String board_file_check;
	
	// 첨부파일 업로드 추가
	private int file_no;
	private String org_file_name;
	private String stored_file_name;
	private int file_size;
	private Date file_date;
	private String del_gb;
	
	
	
	
	public int getFile_no() {
		return file_no;
	}
	public String getOrg_file_name() {
		return org_file_name;
	}
	public String getStored_file_name() {
		return stored_file_name;
	}
	public int getFile_size() {
		return file_size;
	}
	public Date getFile_date() {
		return file_date;
	}
	public String getDel_gb() {
		return del_gb;
	}
	public void setFile_no(int file_no) {
		this.file_no = file_no;
	}
	public void setOrg_file_name(String org_file_name) {
		this.org_file_name = org_file_name;
	}
	public void setStored_file_name(String stored_file_name) {
		this.stored_file_name = stored_file_name;
	}
	public void setFile_size(int file_size) {
		this.file_size = file_size;
	}
	public void setFile_date(Date file_date) {
		this.file_date = file_date;
	}
	public void setDel_gb(String del_gb) {
		this.del_gb = del_gb;
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
	public String getMember_nick() {
		return member_nick;
	}
	public void setMember_nick(String member_nick) {
		this.member_nick = member_nick;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_file_check() {
		return board_file_check;
	}
	public void setBoard_file_check(String board_file_check) {
		this.board_file_check = board_file_check;
	}
	
	@Override
	public String toString() {
		return "CommentModel [bcomment_no=" + bcomment_no + ", board_no=" + board_no + ", bcomment_content="
				+ bcomment_content + ", bcomment_date=" + bcomment_date + ", member_no=" + member_no
				+ ", bcomment_report_count=" + bcomment_report_count + ", bcomment_like_count=" + bcomment_like_count
				+ ", ref_step=" + ref_step + ", ref_level=" + ref_level + ", member_nick=" + member_nick
				+ ", board_title=" + board_title + ", board_file_check=" + board_file_check + "]";
	}
	
	
	
	
	
	
	
}
