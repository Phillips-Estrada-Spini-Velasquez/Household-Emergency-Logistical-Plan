package help.controllers;

import help.models.Message;
import help.repositories.MessageRepository;
import help.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MessageController {

    private final MessageRepository messageDao;
    private final UserRepository userDao;
//    private final EmailService emailService;

    public MessageController(MessageRepository messageDao, UserRepository userDao) {
        this.messageDao = messageDao;
        this.userDao = userDao;
//email service
    }

    @GetMapping("/messages")
    public String index(Model model) {
        model.addAttribute("messages", messageDao.findAll());
        return "/messages/index";
    }

    @GetMapping("/messages.json")
    public @ResponseBody List<Message> viewAllMessagesInJSONFormat() {
        return messageDao.findAll();
    }

    @GetMapping("/messages/ajax")
    public String viewAllMessagesWithAjax() {
        return "messages/ajax";
    }

    @GetMapping("/messages/show/{id}")
    public String getMessageById(@PathVariable long id, Model model) {
        model.addAttribute("message", messageDao.getOne(id));
        model.addAttribute("user", userDao.getOne(1L));
//        model.addAttribute("email", userDao.getOne(1L).getEmail());
        return "/messages/show";
    }

    @GetMapping(path = "/messages/create")
    public String createMessageForm(Model model) {
        model.addAttribute("message", new Message());
        model.addAttribute("user", userDao.getOne(1L));
        return "/messages/create";
    }

    @PostMapping("/messages/create")
    public String createMessage(@ModelAttribute Message message) {
        message.setOwner(userDao.findAll().get(0));
        messageDao.save(message);
//        emailService.prepareAndSendPost(message, "New Post Created: " + message.getTitle(), message.getBody());
        return "redirect:/messages";
    }

    @GetMapping(path = "/messages/{id}/edit")
    public String editMessageForm(@PathVariable long id, Model model) {
        Message message = messageDao.getOne(id);
        model.addAttribute("id", id);
        model.addAttribute("message", message);
        return "/messages/edit";
    }

    @PostMapping(path = "/messages/{id}/edit")
    public String editMessage(@PathVariable long id, Model model
    ) {
        Message message = messageDao.getOne(id);
        model.addAttribute("message",message);
        messageDao.save(message);
//        emailService.prepareAndSendPost(message, ("Post Edited: " + message.getTitle()), message.getDescription());
        return "redirect:/messages/show/ + {id}";
    }

    @GetMapping(path = "/messages/delete/{id}")
    public String deleteMessageById(@PathVariable long id) {
        Message message = messageDao.getOne(id);
        message.setOwner(messageDao.getOne(id).getOwner());
        messageDao.deleteById(id);
//        emailService.prepareAndSendPost(message, ("Post Deleted: " + message.getTitle()), message.getBody());
        return "/messages/delete-message";
    }

}
