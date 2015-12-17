package com.chataround.chataroundws.service;

import com.chataround.chataroundws.model.DTO.MessageDTO;

import java.util.List;

/**
 * @author Georgia Grigoriadou
 */
public interface IMessageService {
    void addMessage(MessageDTO dto);

    List<MessageDTO> getMessages(String username);
}
