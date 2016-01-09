package com.chataround.chataroundws.service;

import com.chataround.chataroundws.exception.UserNotFoundException;
import com.chataround.chataroundws.mapper.IMapper;
import com.chataround.chataroundws.model.DTO.MessageDTO;
import com.chataround.chataroundws.model.entity.Message;
import com.chataround.chataroundws.repository.MessageRepository;
import com.chataround.chataroundws.repository.UserRepository;
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
    UserRepository userRepository;

    @Autowired
    IMapper<Message,MessageDTO> messageMapper;


    @Override
    public void addMessage(MessageDTO dto){
        if(!userRepository.exists(dto.getUsername())) throw new UserNotFoundException();
        Message message=messageMapper.fromDTO(dto);
        messageRepository.saveAndFlush(message);

        if(message.getDuration()!=0) {
            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            messageRepository.delete(message.getId());
                        }

                    }, message.getDuration() * 1000
            );
        }


    }

    @Override
    public List<MessageDTO> getMessages(String username) {
        if(!userRepository.exists(username)) throw new UserNotFoundException();
        return messageMapper.toDTO(messageRepository.findByUsername(username));
    }


}
