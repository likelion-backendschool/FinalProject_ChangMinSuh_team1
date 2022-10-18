package com.example.ebook.domain.member.controller;

import com.example.ebook.domain.member.dtos.SignupDto;
import com.example.ebook.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("signup")
    public String signup(SignupDto signupDto){
        return "member/signup_form";
    }

    @PostMapping("signup")
    public String signup(
            @Valid SignupDto signupDto,
            BindingResult bindingResult
    ){
        if (bindingResult.hasErrors()) {
            return "member/signup_form";
        }

        if (!signupDto.getPassword().equals(signupDto.getPasswordChk())) {
            bindingResult.rejectValue("passwordChk", "passwordInCorrect",
                    "2개의 패스워드가 일치하지 않습니다.");
            return "member/signup_form";
        }

        memberService.signup(signupDto);

        return "redirect:/";
    }

    @GetMapping("login")
    public String login(){
        return "member/login_form";
    }
}
