package com.chat.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.exception.ChatException;
import com.chat.exception.MessageException;
import com.chat.exception.UserException;
import com.chat.modal.Chat;
import com.chat.modal.Message;
import com.chat.modal.User;
import com.chat.repository.MessageRepository;
import com.chat.request.SendMessageRequest;

@Service
public class MessageServiceImplement implements MessageService{
	
	@Autowired
	private MessageRepository messageRepo;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ChatService chatService;
	
	  

	@Override
	public Message sendMessage(SendMessageRequest req) throws UserException, ChatException {
		
		System.out.println("send message ------- ");
		
		User user=userService.findUserById(req.getUserId());
		Chat chat=chatService.findChatById(req.getChatId());
		
		Message message=new Message();
		message.setChat(chat);
		message.setUser(user);
		message.setContent(req.getContent());
		message.setTimeStamp(LocalDateTime.now());
		message.setIs_read(false);
		
		
		return messageRepo.save(message);
	}

	@Override
	public String deleteMessage(Integer messageId) throws MessageException {
		
		Message message=findMessageById(messageId);
		
		messageRepo.deleteById(message.getId());
		
		return "message deleted successfully";
	}

	@Override
	public List<Message> getChatsMessages(Integer chatId) throws ChatException {
		
		Chat chat=chatService.findChatById(chatId);
		
		List<Message> messages=messageRepo.findMessageByChatId(chatId);
		
		return messages;
	}

	@Override
	public Message findMessageById(Integer messageId) throws MessageException {
		
		Optional<Message> message =messageRepo.findById(messageId);
		
		if(message.isPresent()) {
			return message.get();
		}
		throw new MessageException("message not exist with id "+messageId);
	}

}
