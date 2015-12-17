package com.chataround.chataroundws.controller;

import com.chataround.chataroundws.model.DTO.MessageDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Georgia Grigoriadou
 */
public interface IMessageController {
    ResponseEntity<?> createMessage(MessageDTO dto, Model model);

    ResponseEntity<List<MessageDTO>> getMessages(String username );
}
