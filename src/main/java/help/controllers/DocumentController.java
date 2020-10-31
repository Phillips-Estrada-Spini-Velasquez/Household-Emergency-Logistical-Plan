package help.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DocumentController {

//    // redirecting login user into their profile page
//    @GetMapping("/the-plan")
//    public String profilePage(Model model) {
//        User getUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        model.addAttribute("user", userDao.getOne(getUser.getId()));
//        model.addAttribute("photoUrl", userDao.getOne(getUser.getId()).getProfilePic());
//        return "users/profile";
//    }
//
//    //user's biography area
//    @PostMapping("/profile/pic")
//    public String saveProfile(@RequestParam long userId, @RequestParam String url, @ModelAttribute User user) {
//        User saveProfile = userDao.getOne(userId);
//        saveProfile.setProfilePic(url);
//        userDao.save(saveProfile);
//        return "redirect:/profile";
//    }

}