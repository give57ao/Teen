<<<<<<< HEAD
package com.ez.teen.board.model;

import java.util.Date;

public class BoardModel {

	private int board_no;
	private int member_no;
	private String board_title;
	private String board_content;
	private Date board_date;
	private int board_hit_count;
	private int board_like_count;
	private int board_report_count;
	private String board_file_check;
	private String board_group_no;
	private String board_tag_no;
	private String tag_name;
	private String member_nick;
	private int board_comment_count;
	
	//첨부파일 업로드 추가
	private int file_no;
	private String org_file_name;
	private String stored_file_name;
	private int file_size;
	private Date file_date;
	private String del_gb;

	public int getBoard_comment_count() {
		return board_comment_count;
	}
	public void setBoard_comment_count(int board_comment_count) {
		this.board_comment_count = board_comment_count;
	}
	public String getMember_nick() {
		return member_nick;
	}
	public void setMember_nick(String member_nick) {
		this.member_nick = member_nick;
	}
	
	
	public int getBoard_no() {
		return board_no;
	}
	public String getTag_name() {
		return tag_name;
	}
	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public Date getBoard_date() {
		return board_date;
	}
	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}
	public int getBoard_hit_count() {
		return board_hit_count;
	}
	public void setBoard_hit_count(int board_hit_count) {
		this.board_hit_count = board_hit_count;
	}
	public int getBoard_like_count() {
		return board_like_count;
	}
	public void setBoard_like_count(int board_like_count) {
		this.board_like_count = board_like_count;
	}
	public int getBoard_report_count() {
		return board_report_count;
	}
	public void setBoard_report_count(int board_report_count) {
		this.board_report_count = board_report_count;
	}
	public String getBoard_file_check() {
		return board_file_check;
	}
	public void setBoard_file_check(String board_file_check) {
		this.board_file_check = board_file_check;
	}
	public String getBoard_group_no() {
		return board_group_no;
	}
	public void setBoard_group_no(String board_group_no) {
		this.board_group_no = board_group_no;
	}
	public String getBoard_tag_no() {
		return board_tag_no;
	}
	public void setBoard_tag_no(String board_tag_no) {
		this.board_tag_no = board_tag_no;
	}

	public int getFile_no() {
		return file_no;
	}
	public void setFile_no(int file_no) {
		this.file_no = file_no;
	}
	public String getOrg_file_name() {
		return org_file_name;
	}
	public void setOrg_file_name(String org_file_name) {
		this.org_file_name = org_file_name;
	}
	public String getStored_file_name() {
		return stored_file_name;
	}
	public void setStored_file_name(String stored_file_name) {
		this.stored_file_name = stored_file_name;
	}
	public int getFile_size() {
		return file_size;
	}
	public void setFile_size(int file_size) {
		this.file_size = file_size;
	}
	public Date getFile_date() {
		return file_date;
	}
	public void setFile_date(Date file_date) {
		this.file_date = file_date;
	}
	public String getDel_gb() {
		return del_gb;
	}
	public void setDel_gb(String del_gb) {
		this.del_gb = del_gb;
	}
	
	
	@Override
	public String toString() {
		return "BoardModel [board_no=" + board_no + ", member_no=" + member_no + ", board_title=" + board_title
				+ ", board_content=" + board_content + ", board_date=" + board_date + ", board_hit_count="
				+ board_hit_count + ", board_like_count=" + board_like_count + ", board_report_count="
				+ board_report_count + ", board_file_check=" + board_file_check + ", board_group_no=" + board_group_no
				+ ", board_tag_no=" + board_tag_no + ", tag_name=" + tag_name + ", member_nick=" + member_nick
				+ ", board_comment_count=" + board_comment_count + ", file_no=" + file_no + ", org_file_name="
				+ org_file_name + ", stored_file_name=" + stored_file_name + ", file_size=" + file_size + ", file_date="
				+ file_date + ", del_gb=" + del_gb + "]";
	}

	
}
=======
package com.ez.teen.board.model;

import java.util.Date;

public class BoardModel {

	private int board_no; 
	private int member_no; 
	private String board_title; 
	private String board_content; 
	private Date board_date; 
	private int board_hit_count; 
	private int board__like_count;
	private int board_report_count;
	private String board_file_check;
	private String board_group_no;
	private String board_tag_no;
	
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public Date getBoard_date() {
		return board_date;
	}
	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}
	public int getBoard_hit_count() {
		return board_hit_count;
	}
	public void setBoard_hit_count(int board_hit_count) {
		this.board_hit_count = board_hit_count;
	}
	public int getBoard__like_count() {
		return board__like_count;
	}
	public void setBoard__like_count(int board__like_count) {
		this.board__like_count = board__like_count;
	}
	public int getBoard_report_count() {
		return board_report_count;
	}
	public void setBoard_report_count(int board_report_count) {
		this.board_report_count = board_report_count;
	}
	public String getBoard_file_check() {
		return board_file_check;
	}
	public void setBoard_file_check(String board_file_check) {
		this.board_file_check = board_file_check;
	}
	public String getBoard_group_no() {
		return board_group_no;
	}
	public void setBoard_group_no(String board_group_no) {
		this.board_group_no = board_group_no;
	}
	public String getBoard_tag_no() {
		return board_tag_no;
	}
	public void setBoard_tag_no(String board_tag_no) {
		this.board_tag_no = board_tag_no;
	}
	
	
	
	
	
	
}
>>>>>>> refs/remotes/origin/dong_hyuk
