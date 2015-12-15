package com.chataround.chataroundws.controller;


import com.chataround.chataroundws.model.DTO.InMessageDTO;
import com.chataround.chataroundws.model.DTO.OutMessageDTO;
import com.chataround.chataroundws.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Georgia Grigoriadou
 */
@RestController
@RequestMapping(value="/message")
public class MessageController implements IMessageController {

    @Autowired
    IMessageService messageService;

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createMessage(InMessageDTO dto, Model model) {
        messageService.addMessage(dto);
        return ResponseEntity.ok(HttpStatus.OK);
    }



    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<OutMessageDTO>> getMessages(@RequestParam("id") Long id) {
        List<OutMessageDTO> msgDTOs = messageService.getMessages(id);
        return ResponseEntity
                .ok(msgDTOs);

    }

}
