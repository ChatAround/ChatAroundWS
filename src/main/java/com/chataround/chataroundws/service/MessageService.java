package com.chataround.chataroundws.service;

import com.chataround.chataroundws.mapper.IMapper;
import com.chataround.chataroundws.model.DTO.InMessageDTO;
import com.chataround.chataroundws.model.DTO.OutMessageDTO;
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
    IMapper<Message,InMessageDTO> inMessageMapper;

    @Autowired
    IMapper<Message,OutMessageDTO> outMessageMapper;

    @Override
    public void addMessage(InMessageDTO dto){
        messageRepository.saveAndFlush(inMessageMapper.fromDTO(dto));

    }

    @Override
    public List<OutMessageDTO> getMessages(Long id) {
        return outMessageMapper.toDTO(messageRepository.findById(id));
    }


}
