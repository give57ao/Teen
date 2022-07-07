package com.ez.teen.admin.model;

public class ChatParam {

	private String member_nick; //수정전 닉네임
	private String mod_member_nick; //수정 후 닉네임

	public String getMember_nick() {
		return member_nick;
	}

	public void setMember_nick(String member_nick) {
		this.member_nick = member_nick;
	}

	public String getMod_member_nick() {
		return mod_member_nick;
	}

	public void setMod_member_nick(String mod_member_nick) {
		this.mod_member_nick = mod_member_nick;
	}
}