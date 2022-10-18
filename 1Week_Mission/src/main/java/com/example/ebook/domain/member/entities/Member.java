package com.example.ebook.domain.member.entities;

import com.example.ebook.domain.post.entities.Post;
import com.example.ebook.domain.product.entities.Product;
import com.example.ebook.global.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@SuperBuilder
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {
    @Column(unique = true)
    private String username;
    @Column()
    private String password;
    @Column()
    private String nickname;
    @Column()
    private String email;
    @Column()
    private Short authLevel;

    @OneToMany(mappedBy = "author")
    private List<Post> posts;

    @OneToMany(mappedBy = "author")
    private List<Product> products;
}
