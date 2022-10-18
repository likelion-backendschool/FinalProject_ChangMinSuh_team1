package com.example.ebook.domain.member.service;

import com.example.ebook.domain.member.dtos.SignupDto;
import com.example.ebook.domain.member.entities.Member;
import com.example.ebook.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Member signup(SignupDto signupDto){
        Member member = signupDto.toEntity();

        member.changePassword(passwordEncoder.encode(member.getPassword()));

        memberRepository.save(member);

        return member;
    }

    public String findUsername(String email) {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("해당 이메일을 가진 멤버가 존재하지 않습니다."));

        return member.getUsername();
    }
}
