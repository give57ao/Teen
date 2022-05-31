package com.ez.teen.board.model;

public class BoardParam {

   private int member_no;
   private String sort; //정렬
   private String search; //검색 타입 
   public String getSearch() {
      return search;
   }

   public void setSearch(String search) {
      this.search = search;
   }

   String keyword; //검색내용
   

      
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

   private int nowPage, startPage, endPage, total, cntPerPage, lastPage, start, end;
   private int cntPage = 10;

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
      calcStartEndPage(getNowPage(), cntPage); //(1,10)
      calcStartEnd(getNowPage(), getCntPerPage());
   }

   public void calcLastPage(int total, int cntPerPage) {
      setLastPage((int) Math.ceil((double) total / (double) cntPerPage));
   }

   public void calcStartEndPage(int nowPage, int cntPage) { //(1,10)
      setEndPage(((int) Math.ceil((double) nowPage / (double) cntPage)) * cntPage); //0
      //endPage = 1이 되야 하는데 0 이 됌
      //Math.ceil() 함수는 주어진 숫자보다 크거나 같은 숫자 중 가장 작은 숫자를 integer 로 반환
      if (getLastPage() < getEndPage()) { //0 < 1
         setEndPage(getLastPage());
      }
      //아닐 시
      setStartPage(getEndPage() - cntPage + 1); //0-10+1 = -9 
      if (getStartPage() < 1) {
         setStartPage(1);
      
      }
   }
	public void calcStartEndPage(int nowPage, int cntPage) { // (1,10)
		setEndPage(((int) Math.ceil((double) nowPage / (double) cntPage)) * cntPage); // 0

		// Math.ceil() 함수는 주어진 숫자보다 크거나 같은 숫자 중 가장 작은 숫자를 integer 로 반환
		if (getLastPage() < getEndPage()) { // 0 < 0
			setEndPage(getLastPage());
		}
		// 아닐 시
		setStartPage(getEndPage() - cntPage + 1); // 0-5+1 = -4
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

   
   
   //05/26 병합
   
   
   
}
