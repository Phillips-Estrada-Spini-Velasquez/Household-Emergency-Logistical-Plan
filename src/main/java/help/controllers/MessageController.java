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

    //    private final EmailService emailService;
    public MessageController(MessageRepository messageDao, UserRepository userDao, GroupRepository groupDao) {
        this.messageDao = messageDao;
        this.userDao = userDao;
//email service
        this.groupDao = groupDao;
    }

    @GetMapping("/messages.json")
    public @ResponseBody
    List<Message> viewAllMessagesInJSONFormat() {
        User thisAuthor = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User thisUser = userDao.getOne(thisAuthor.getId());
        Group group = groupDao.findById(thisUser.getGroupID()).orElse(null);
        if (group == null) {
            //Returns empty list
            return new ArrayList<Message>();
        }
        return group.getMessages();
//          return messageDao.findAll();
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

    // if group_id == current group display messages
    // grab group_id from messages --> if group_id in messages == group_id in users --> display messages

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

    //Works, need to add button for delete
    @GetMapping(path = "/messages/delete/{id}")
    public String deleteMessageById(@PathVariable long id) {
        Message message = messageDao.getOne(id);
        message.setOwner(messageDao.getOne(id).getOwner());
        messageDao.deleteById(id);
//        emailService.prepareAndSendPost(message, ("Post Deleted: " + message.getTitle()), message.getBody());
        return "redirect:/messages";
    }

//    @PostMapping("/messages/submit")
//    public String createMessage(@ModelAttribute Message message, @ModelAttribute User user) {
//        long userId = user.getId();
//        message.setOwner(userDao.getOne(userId));
//        messageDao.save(message);
////        emailService.prepareAndSendPost(message, "New Post Created: " + message.getTitle(), message.getBody());
//        return "redirect:/messages";
//    }
//
//    @PostMapping("/posts/create")
//    public String postPost(@ModelAttribute Post post) {
//        String update;
//        if (post.getId() == 0) {
//            update = "Create Post: ";
//            User thisAuthor = (User) SecurityContextHolder.getContext().getAuthentication();
//            post.setUser(thisAuthor);
//
//            emailService.prepareAndSend(post.getUser().getEmail(),
//                    "Created Post: " + post.getTitle(),
//                    post.getTitle() + "\n\n" + post.getBody());
//        } else {
//            update = "Edited Post: ";
//            post.setUser(postRepo.getOne(post.getId()).getUser());
//            emailService.prepareAndSend(post.getUser().getEmail(),
//                    "Edited Post: " + post.getTitle(),
//                    post.getTitle() + "\n\n" + post.getBody());
//        }
//        postRepo.save(post);
//        return "redirect:/posts/" + post.getId();
//    }

//    @GetMapping(path = "/messages/{id}/edit")
//    public String editMessageForm(@PathVariable long id, Model model) {
//        Message message = messageDao.getOne(id);
//        model.addAttribute("id", id);
//        model.addAttribute("message", message);
//        return "/messages/edit";
//    }
//
//    @PostMapping(path = "/messages/{id}/edit")
//    public String editMessage(@PathVariable long id, Model model
//    ) {
//        Message message = messageDao.getOne(id);
//        model.addAttribute("message",message);
//        messageDao.save(message);
////        emailService.prepareAndSendPost(message, ("Post Edited: " + message.getTitle()), message.getDescription());
//        return "redirect:/messages/show/ + {id}";
//    }
//

}