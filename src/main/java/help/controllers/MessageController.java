package help.controllers;

import help.repositories.MessageRepository;

public class MessageController {

    private final MessageRepository messageDao;

    public MessageController(MessageRepository messageDao) {
        this.messageDao = messageDao;
    }
}
