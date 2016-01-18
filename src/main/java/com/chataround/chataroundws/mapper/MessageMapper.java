package com.chataround.chataroundws.mapper;

import com.chataround.chataroundws.model.DTO.MessageDTO;
import com.chataround.chataroundws.model.entity.Message;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gewrgia
 */

@Component
public class MessageMapper implements IMapper<Message,MessageDTO> {
    @Override
    public Message fromDTO(MessageDTO dto) {
        Message message=new Message(
                dto.getUsername(),
                dto.getContent(),
                dto.getRadius(),
                dto.getDuration()
        );
        return message;
    }

    @Override
    public List<Message> fromDTO(List<MessageDTO> DTOs) {
        List<Message> messages=new ArrayList<>();

        for(MessageDTO dto:DTOs){
            messages.add(fromDTO(dto));
        }

        return messages;
    }

    @Override
    public MessageDTO toDTO(Message message) {
        MessageDTO dto=new MessageDTO(
                message.getId(),
                message.getUsername(),
                message.getContent(),
                message.getRadius(),
                message.getDuration()
        );
        return dto;

    }

    @Override
    public List<MessageDTO> toDTO(List<Message> messages) {
        List<MessageDTO> messageDTOs = new ArrayList<>();

        for (Message message : messages) {
            messageDTOs.add(toDTO(message));
        }

        return messageDTOs;
    }
}

