package com.example.ebook.domain.post.service;

import com.example.ebook.domain.post.entities.Post;
import com.example.ebook.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;


    public List<Post> findPosts() {
        return postRepository.findAll();
    }

    public Post findOnePost(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시판을 찾을 수 없습니다."));
    }
}
