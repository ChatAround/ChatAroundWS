package com.chataround.chataroundws.service;

import com.chataround.chataroundws.model.DTO.InMessageDTO;
import com.chataround.chataroundws.model.DTO.OutMessageDTO;

import java.util.List;

/**
 * @author Georgia Grigoriadou
 */
public interface IMessageService {
    void addMessage(InMessageDTO dto);

    List<OutMessageDTO> getMessages(Long id);
}
