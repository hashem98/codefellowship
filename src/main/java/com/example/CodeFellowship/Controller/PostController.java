package com.example.CodeFellowship.Controller;

import com.example.CodeFellowship.Model.ApplicationUser;
import com.example.CodeFellowship.Model.Post;
import com.example.CodeFellowship.Repositories.ApplicationUserRepository;
import com.example.CodeFellowship.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class PostController {

    @Autowired
    PostRepository postRepository;

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @PostMapping("/post/{id}")
    public RedirectView newPost(@PathVariable Long id, String body){

        ApplicationUser user = applicationUserRepository.findUserById(id);
        Post newPost = new Post(body, user);

        postRepository.save(newPost);

        return new RedirectView("/");
    }
}