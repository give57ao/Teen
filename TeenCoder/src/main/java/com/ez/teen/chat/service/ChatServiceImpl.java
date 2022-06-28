package com.ez.teen.chat.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ez.teen.chat.mapper.ChatMapper;
import com.ez.teen.chat.model.ChatModel;

@Service
public class ChatServiceImpl implements ChatService{

	@Autowired
	private ChatMapper chatMapper;

	@Override
	public ArrayList<ChatModel> message_list(ChatModel chatModel) {
		
		String member_nick = chatModel.getMember_nick();
		
		ArrayList<ChatModel> list = chatMapper.message_list(chatModel);
		
		for(ChatModel cm : list) {
			cm.setMember_nick(member_nick);
			
			int unread = chatMapper.count_unread(cm);
			
			String member_profile = chatMapper.get_other_profile(cm);
			
			cm.setUnread(unread);
			
			cm.setMember_profile(member_profile);
			
			if(member_nick.equals(cm.getSend_nick())) {
				cm.setOther_nick(cm.getRecv_nick());
			}else {
				cm.setOther_nick(cm.getSend_nick());
			}
		}
		return list;
	}

	@Override
	public ArrayList<ChatModel> room_content_list(ChatModel chatModel) {
		
		System.out.println("room : " + chatModel.getRoom());
		System.out.println("recv_nick : " + chatModel.getRecv_nick());
		System.out.println("member_nick : " + chatModel.getMember_nick());
		
		ArrayList<ChatModel> clist = chatMapper.room_content_list(chatModel);
		
		chatMapper.message_read_chk(chatModel);
		
		return clist;
	}

	@Override
	public int messageSendInlist(ChatModel chatModel) {
		
		
		if(chatModel.getRoom() == 0) {
			int exist_chat = chatMapper.exist_chat(chatModel);
			
			if(exist_chat == 0) {
				int max_room = chatMapper.max_room(chatModel);
				chatModel.setRoom(max_room+1);
			}else {
				int room = chatMapper.select_room(chatModel);
				chatModel.setRoom(room);
			}
		}
		
		int flag = chatMapper.messageSendInlist(chatModel);
		return flag;
	}

	@Override
	public int exist_chat(ChatModel chatModel) {
		return chatMapper.exist_chat(chatModel);
	}

	@Override
	public int count_unread(ChatModel chatModel) {
		return chatMapper.count_unread(chatModel);
	}

	@Override
	public String get_other_profile(ChatModel chatModel) {
		return chatMapper.get_other_profile(chatModel);
	}

	@Override
	public int max_room(ChatModel chatModel) {
		return chatMapper.max_room(chatModel);
	}

	@Override
	public int select_room(ChatModel chatModel) {
		return chatMapper.select_room(chatModel);
	}

	@Override
	public void message_read_chk(ChatModel chatModel) {
		chatMapper.message_read_chk(chatModel);
	}

	
	
	
}
