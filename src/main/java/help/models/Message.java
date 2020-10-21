package help.models;

import help.repositories.MessageRepository;

public class Message {

    private final MessageRepository messageDao;

    public Message(MessageRepository messageDao) {
        this.messageDao = messageDao;
    }
}
