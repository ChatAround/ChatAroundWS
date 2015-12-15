package com.chataround.chataroundws.service;

import com.chataround.chataroundws.model.DTO.InMessageDTO;
import com.chataround.chataroundws.model.DTO.OutMessageDTO;
import com.chataround.chataroundws.model.entity.Message;
import com.chataround.chataroundws.model.entity.User;
import com.chataround.chataroundws.repository.MessageRepository;
import com.chataround.chataroundws.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public void addMessage(InMessageDTO dto){
        User sender=userRepository.findOne(dto.getId());
        List<User> receivers=userRepository.findInRadius(
                sender.getCoordinates().getLatitude(),
                sender.getCoordinates().getLongitude(),
                dto.getRadius()
        );
        for(User receiver:receivers) {
            Message message = new Message();
            message.setSenderId(sender.getId());
            message.setContent(dto.getContent());
            message.setReceiverId(receiver.getId());
            message.setHasSent(false);
            messageRepository.saveAndFlush(message);
        }
    }

    @Override
    public List<OutMessageDTO> getMessages(Long id) {
        List<OutMessageDTO> messageDTOs=new ArrayList<>();
        for(Message message:messageRepository.findByUserId(id)){
            if (!message.isHasSent()) {
                User sender = userRepository.findOne(message.getSenderId());
                OutMessageDTO msgDTO = new OutMessageDTO(
                        message.getId(),
                        sender.getUsername(),
                        message.getContent()
                );
                messageDTOs.add(msgDTO);
                message.setHasSent(true);
                messageRepository.saveAndFlush(message);
            }
        }
        return messageDTOs;
    }


}
