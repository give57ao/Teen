package com.ez.teen.board.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

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
	
	@Override
	public String toString() {
		return "BoardModel [board_no=" + board_no + ", member_no=" + member_no + ", board_title=" + board_title
				+ ", board_content=" + board_content + ", board_date=" + board_date + ", board_hit_count="
				+ board_hit_count + ", board_like_count=" + board_like_count + ", board_report_count="
				+ board_report_count + ", board_file_check=" + board_file_check + ", board_group_no=" + board_group_no
				+ ", board_tag_no=" + board_tag_no + "]";

}
}