package me.double8.admin.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.double8.admin.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberLoginController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String login() {
        return "login/loginPage";
    }

}
