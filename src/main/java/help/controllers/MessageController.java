package help.controllers;

import help.repositories.MessageRepository;
import org.springframework.web.bind.annotation.GetMapping;

public class MessageController {

    private final MessageRepository messageDao;

    public MessageController(MessageRepository messageDao) {
        this.messageDao = messageDao;
    }

    // testing message
//    @GetMapping("/message")
//    public String testingMessageHtml() {
//        return "messages/index";
//    }
}
