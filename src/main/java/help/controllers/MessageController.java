package help.controllers;

import help.models.Message;
import help.models.User;
import help.repositories.MessageRepository;
import help.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
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


    @GetMapping("/messages.json")
    public @ResponseBody List<Message> viewAllMessagesInJSONFormat() {
        return messageDao.findAll();
    }

    @GetMapping("/messages")
    public String viewAllMessagesWithAjax(Model model) {
        model.addAttribute("message", new Message());
        return "messages/ajax";
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
    @PostMapping("/messages/submit")
    public String createAd(@ModelAttribute Message message) {

        // set flag values for a create email
        if (message.getId() == 0) {
            User thisAuthor = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            message.setOwner(thisAuthor);
        }
        // set flag values for an edit email
        else {
            message.setOwner(messageDao.getOne(message.getId()).getOwner());
        }
        messageDao.save(message);
        return "redirect:/messages";
    }


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




    //    @GetMapping(path = "/messages")
//    public String createMessageForm(Model model) {
//        model.addAttribute("message", new Message());
//        model.addAttribute("user", userDao.getOne(1L));
//        return "/messages/ajax";
//    }


//    @GetMapping("/messages/show/{id}")
//    public String getMessageById(@PathVariable long id, Model model) {
//        model.addAttribute("message", messageDao.getOne(id));
//        model.addAttribute("user", userDao.getOne(1L));
////        model.addAttribute("email", userDao.getOne(1L).getEmail());
//        return "/messages/show";
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
//    @GetMapping(path = "/messages/delete/{id}")
//    public String deleteMessageById(@PathVariable long id) {
//        Message message = messageDao.getOne(id);
//        message.setOwner(messageDao.getOne(id).getOwner());
//        messageDao.deleteById(id);
////        emailService.prepareAndSendPost(message, ("Post Deleted: " + message.getTitle()), message.getBody());
//        return "/messages/delete-message";
//    }

}
