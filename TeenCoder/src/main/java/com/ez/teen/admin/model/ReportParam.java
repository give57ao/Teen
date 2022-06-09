package com.ez.teen.admin.model;

public class ReportParam {
	
	private String board_group_no;
	private String board_tag_name;
	private int board_no;
	private String sort; // �젙�젹
	private String search; // 寃��깋 ���엯
	private int member_no;
	private String keyword; // 寃��깋�궡�슜
	private int nowPage, startPage, endPage, total, cntPerPage, lastPage, start, end;
	private int cntPage = 10;
	private int ref_level;

	
	public int getRef_level() {
		return ref_level;
	}

	public void setRef_level(int ref_level) {
		this.ref_level = ref_level;
	}

	public int getBoard_no() {
		return board_no;
	}
	
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	
	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public void PagingModel() {
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public void PagingModel(int total, int nowPage, int cntPerPage) {
		setNowPage(nowPage);
		setCntPerPage(cntPerPage);
		setTotal(total);
		calcLastPage(getTotal(), getCntPerPage());
		calcStartEndPage(getNowPage(), cntPage); // (1,10)
		calcStartEnd(getNowPage(), getCntPerPage());
	}

	public void calcLastPage(int total, int cntPerPage) {
		setLastPage((int) Math.ceil((double) total / (double) cntPerPage));
	}

	public void calcStartEndPage(int nowPage, int cntPage) { // (1,10)
		setEndPage(((int) Math.ceil((double) nowPage / (double) cntPage)) * cntPage); // 0
		// endPage = 1�씠 �릺�빞 �븯�뒗�뜲 0 �씠 �릪
		// Math.ceil() �븿�닔�뒗 二쇱뼱吏� �닽�옄蹂대떎 �겕嫄곕굹 媛숈� �닽�옄 以� 媛��옣 �옉�� �닽�옄瑜� integer 濡� 諛섑솚
		if (getLastPage() < getEndPage()) { // 0 < 1
			setEndPage(getLastPage());
		}
		// �븘�땺 �떆
		setStartPage(getEndPage() - cntPage + 1); // 0-10+1 = -9
		if (getStartPage() < 1) {
			setStartPage(1);

		}
	}

	

	public void calcStartEnd(int nowPage, int cntPerPage) {
		setEnd(nowPage * cntPerPage);
		setStart(getEnd() - cntPerPage + 1);
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCntPerPage() {
		return cntPerPage;
	}

	public void setCntPerPage(int cntPerPage) {
		this.cntPerPage = cntPerPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int setCntPage() {
		return cntPage;
	}

	public void getCntPage(int cntPage) {
		this.cntPage = cntPage;
	}

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


}
