package com.example.CodeFellowship.Controller;


import com.example.CodeFellowship.Model.ApplicationUser;
import com.example.CodeFellowship.Repositories.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import java.sql.Date;
import java.util.ArrayList;

@Controller
public class signUpController {


    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/signup")
    public String signupPage(){
        return "signup";
    }


    @PostMapping("/signup")
    public RedirectView createUSer( String userName,
                                    String password,
                                    String firstName,
                                    String lastName,
                                    Date dateOfBirth,
                                    String bio){


        ApplicationUser newUser = new ApplicationUser(userName, bCryptPasswordEncoder.encode(password), firstName, lastName, dateOfBirth, bio);
        applicationUserRepository.save(newUser);

        Authentication authentication = new UsernamePasswordAuthenticationToken(newUser, null, new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new RedirectView("/profile");
    }

}