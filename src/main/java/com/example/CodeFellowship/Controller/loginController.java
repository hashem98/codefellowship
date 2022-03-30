package com.example.CodeFellowship.Controller;

import com.example.CodeFellowship.Model.ApplicationUser;
import com.example.CodeFellowship.Repositories.ApplicationUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class loginController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @GetMapping("/login")
    public String getLogin(Principal p, Model m) {
        try {
            ApplicationUser currentUser = applicationUserRepository.findUserByUserName(p.getName());
            if (currentUser != null) {
                new RedirectView("/userDetail");
            }

        } catch (Exception e) {
            System.out.println(e);
            System.out.println(57);
        }
        return "login";
    }
}