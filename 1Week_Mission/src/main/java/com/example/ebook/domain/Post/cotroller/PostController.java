package com.example.ebook.domain.post.cotroller;


import com.example.ebook.domain.post.entities.Post;
import com.example.ebook.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("post")
public class PostController {
    private final PostService postService;

    @GetMapping("list")
    public String findPostList(
            Model model
    ){
        List<Post> posts = postService.findPosts();
        model.addAttribute("'posts", posts);
        return "post/list";
    }
}
