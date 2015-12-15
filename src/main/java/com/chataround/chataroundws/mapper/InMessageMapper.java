package com.chataround.chataroundws.mapper;

import com.chataround.chataroundws.model.DTO.InMessageDTO;
import com.chataround.chataroundws.model.entity.Message;
import com.chataround.chataroundws.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Georgia Grigoriadou
 */
@Component
public class InMessageMapper implements IMapper<Message,InMessageDTO> {
   @Autowired
    UserRepository userRepository;

    @Override
    public Message fromDTO(InMessageDTO dto) {

        Message message=new Message(
                dto.getId(),
                dto.getContent(),
                dto.getRadius()
                );
        return message;
    }

    @Override
    public List<Message> fromDTO(List<InMessageDTO> DTOs) {
        List<Message> messages= new ArrayList<>();

        for (InMessageDTO dto :DTOs){
            messages.add(fromDTO(dto));
        }
        return messages;
    }

    @Override
    public InMessageDTO toDTO(Message model) {
        return null;
    }

    @Override
    public List<InMessageDTO> toDTO(List<Message> models) {
        return null;
    }
}
