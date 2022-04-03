package com.example.CodeFellowship.Controller;


import com.example.CodeFellowship.Model.ApplicationUser;
import com.example.CodeFellowship.Repositories.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
public class userController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @GetMapping("/profile/{id}")
    public String getUser(@PathVariable long id, Model m){

        ApplicationUser currentUser = applicationUserRepository.findUserById(id);
        m.addAttribute("displayedUser", currentUser);
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "profile";
    }




    @GetMapping("/user/{id}")
    public String getUserProfile(@PathVariable Long id, Model model){
        ApplicationUser user = applicationUserRepository.findUserById(id);
        model.addAttribute("displayedUser", user);
        return "profile";
    }





}