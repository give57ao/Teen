package com.ez.teen.chat.service;

import java.util.ArrayList;

import com.ez.teen.chat.model.ChatModel;

public interface ChatService {

	public ArrayList<ChatModel> message_list(ChatModel chatModel);
	
	public ArrayList<ChatModel> room_content_list(ChatModel chatModel);
	
	public int messageSendInlist(ChatModel chatModel);
	
	public int exist_chat(ChatModel chatModel);
	
	public int count_unread(ChatModel chatModel);
	
	public String get_other_profile(ChatModel chatModel);
	
	public int max_room(ChatModel chatModel);
	
	public int select_room(ChatModel chatModel);
	
	public void message_read_chk(ChatModel chatModel);
}
