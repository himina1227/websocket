package com.example.websocket.web;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author : nakgyeom
 * @date : 2023-02-08 오후 4:44
 */
@Slf4j
@Controller
public class ChatController {

    @GetMapping("/chat")
    public String chatGET(){
        log.info("ChatController, chat GET()");
        return "chat";
    }
}
