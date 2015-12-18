package com.chataround.chataroundws.service;

import com.chataround.chataroundws.mapper.IMapper;
import com.chataround.chataroundws.model.DTO.MessageDTO;
import com.chataround.chataroundws.model.entity.Message;
import com.chataround.chataroundws.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Georgia Grigoriadou
 */
@Service
public class MessageService implements IMessageService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    IMapper<Message,MessageDTO> messageMapper;


    @Override
    public void addMessage(MessageDTO dto){
      //  messageRepository.saveAndFlush(messageMapper.fromDTO(dto));
        Message message=messageMapper.fromDTO(dto);
        messageRepository.saveAndFlush(message);
        new java.util.Timer().schedule(
                new java.util.TimerTask(){
                    @Override
                    public void run(){
                        messageRepository.delete(message.getId());
                    }

                },message.getDuration()
        );



    }

    @Override
    public List<MessageDTO> getMessages(String username) {
        return messageMapper.toDTO(messageRepository.findByUsername(username));
    }


}
