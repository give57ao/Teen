package com.ez.teen.board.model;

import java.util.Date;

public class BoardModel {

	private int boardNo;
	private int memberNo;
	private String boardTitle;
	private String boardContent;
	private Date boardDate;
	private int boardHitCount;
	private int boardLikeCount;
	private int boardReportCount;
	private String fileCheck;
	private String boardGroupNo;
	private String boardTagNo;
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	public int getBoardHitCount() {
		return boardHitCount;
	}
	public void setBoardHitCount(int boardHitCount) {
		this.boardHitCount = boardHitCount;
	}
	public int getBoardLikeCount() {
		return boardLikeCount;
	}
	public void setBoardLikeCount(int boardLikeCount) {
		this.boardLikeCount = boardLikeCount;
	}
	public int getBoardReportCount() {
		return boardReportCount;
	}
	public void setBoardReportCount(int boardReportCount) {
		this.boardReportCount = boardReportCount;
	}
	public String getFileCheck() {
		return fileCheck;
	}
	public void setFileCheck(String fileCheck) {
		this.fileCheck = fileCheck;
	}
	public String getBoardGroupNo() {
		return boardGroupNo;
	}
	public void setBoardGroupNo(String boardGroupNo) {
		this.boardGroupNo = boardGroupNo;
	}
	public String getBoardTagNo() {
		return boardTagNo;
	}
	public void setBoardTagNo(String boardTagNo) {
		this.boardTagNo = boardTagNo;
	}
	

	@Override
	public String toString() {
		return "BoardModel [boardNo=" + boardNo + ", memberNo=" + memberNo + ", boardTitle=" + boardTitle
				+ ", boardContent=" + boardContent + ", boardDate=" + boardDate + ", boardHitCount=" + boardHitCount
				+ ", boardLikeCount=" + boardLikeCount + ", boardReportCount=" + boardReportCount + ", fileCheck="
				+ fileCheck + ", boardGroupNo=" + boardGroupNo + ", boardTagNo=" + boardTagNo + "]";
	}
	
	
}
