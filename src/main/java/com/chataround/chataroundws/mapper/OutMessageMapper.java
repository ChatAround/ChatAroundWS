package com.chataround.chataroundws.mapper;

import com.chataround.chataroundws.model.DTO.OutMessageDTO;
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

public class OutMessageMapper implements IMapper<Message,OutMessageDTO> {
    @Autowired
    UserRepository userRepository;

    @Override
    public Message fromDTO(OutMessageDTO dto) {
        return null;
    }

    @Override
    public List<Message> fromDTO(List<OutMessageDTO> DTOs) {
        return null;
    }

    @Override
    public OutMessageDTO toDTO(Message model) {
        OutMessageDTO dto=new OutMessageDTO(
                model.getId(),
                userRepository.findOne(model.getSenderId()).getUsername(),
                model.getContent()
        );
        return dto;
    }

    @Override
    public List<OutMessageDTO> toDTO(List<Message> models) {
        List<OutMessageDTO> msgDTOs= new ArrayList<>();

        for (Message model :models){
            msgDTOs.add(toDTO(model));
        }
        return msgDTOs;
    }
}
