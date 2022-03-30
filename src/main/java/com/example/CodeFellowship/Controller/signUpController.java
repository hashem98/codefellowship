package com.example.CodeFellowship.Controller;

import com.example.CodeFellowship.Model.ApplicationUser;
import com.example.CodeFellowship.Repositories.ApplicationUserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.view.RedirectView;

import java.sql.Date;


@Controller
public class signUpController {


    @RequestMapping("/signup")
    public String signupPage(){
        return "SignUp";
    }

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public RedirectView createUSer(@RequestParam String username,
                                   @RequestParam String password,
                                   @RequestParam String firstName,
                                   @RequestParam String lastName,
                                   @RequestParam Date date,
                                   @RequestParam String bio){
        password = passwordEncoder.encode(password);

        ApplicationUser user = new ApplicationUser(username, password, firstName, lastName, date, bio);
        applicationUserRepository.save(user);
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                user, null, user.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(authToken);
        return new RedirectView("/userDetail");
    }
}