package com.chat.service;

import java.util.List;


import com.chat.exception.ChatException;
import com.chat.exception.MessageException;
import com.chat.exception.UserException;
import com.chat.modal.Message;
import com.chat.request.SendMessageRequest;

public interface MessageService  {
	
	public Message sendMessage(SendMessageRequest req) throws UserException, ChatException;
	
	public List<Message> getChatsMessages(Integer chatId) throws ChatException;
	
	public Message findMessageById(Integer messageId) throws MessageException;
	
	public String deleteMessage(Integer messageId) throws MessageException;

}
