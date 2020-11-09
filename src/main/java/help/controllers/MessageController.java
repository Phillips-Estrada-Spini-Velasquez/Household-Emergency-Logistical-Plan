package help.controllers;

import help.models.Group;
import help.models.Message;
import help.models.User;
import help.repositories.GroupRepository;
import help.repositories.MessageRepository;
import help.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MessageController {
    private final MessageRepository messageDao;
    private final UserRepository userDao;
    private final GroupRepository groupDao;

    public MessageController(MessageRepository messageDao, UserRepository userDao, GroupRepository groupDao) {
        this.messageDao = messageDao;
        this.userDao = userDao;
        this.groupDao = groupDao;
    }

    @GetMapping("/messages.json")
    public @ResponseBody
    List<Message> viewAllMessagesInJSONFormat() {
        User thisAuthor = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User thisUser = userDao.getOne(thisAuthor.getId());
        Group group = groupDao.findById(thisUser.getGroupID()).orElse(null);
        if (group == null) {
            return new ArrayList<Message>();
        }
        return group.getMessages();
    }

    @GetMapping("/messages")
    public String redirectToId() {
        User thisAuthor = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User thisUser = userDao.getOne(thisAuthor.getId());
        return "redirect:/messages/" + thisUser.getGroup().getId();
    }


    @GetMapping("/messages/{id}")
    public String viewAllMessagesWithAjax(@PathVariable long id, Model model) {
        User thisAuthor = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User thisUser = userDao.getOne(thisAuthor.getId());
        model.addAttribute("id", thisUser.getGroup().getId());
        model.addAttribute("user", userDao.getOne(thisAuthor.getId()));
        if (thisUser.getGroup().getId() == id) {
            model.addAttribute("message", new Message());
            return "messages/ajax";
        }
        return "/home";
    }

    @PostMapping("/messages/submit")
    public String createMessage(@ModelAttribute Message message) {
        User thisAuthor = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        message.setOwner(thisAuthor);
        User thisUser = userDao.getOne(thisAuthor.getId());
        Group authorGroup = thisUser.getGroup();
        long groupId = authorGroup.getId();
        Group currentGroup = groupDao.getOne(groupId);
        message.setGroup(currentGroup);
        messageDao.save(message);
        return "redirect:/messages";
    }

    @GetMapping(path = "/messages/delete/{id}")
    public String deleteMessageById(@PathVariable long id) {
        Message message = messageDao.getOne(id);
        message.setOwner(messageDao.getOne(id).getOwner());
        messageDao.deleteById(id);
//        emailService.prepareAndSendPost(message, ("Post Deleted: " + message.getTitle()), message.getBody());
        return "redirect:/messages";
    }
}