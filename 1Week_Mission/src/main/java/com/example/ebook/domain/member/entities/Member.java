package com.example.ebook.domain.member.entities;

import com.example.ebook.global.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;

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
}
