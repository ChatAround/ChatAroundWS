package com.chataround.chataroundws.controller;

import com.chataround.chataroundws.model.DTO.InMessageDTO;
import com.chataround.chataroundws.model.DTO.OutMessageDTO;
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
    @RequestMapping(method = RequestMethod.POST)
    void createMessage(InMessageDTO dto, Model model);



    @RequestMapping(value = "/users", method = RequestMethod.GET)
    ResponseEntity<List<OutMessageDTO>> getMessages(@RequestParam("id") Long id);
}
