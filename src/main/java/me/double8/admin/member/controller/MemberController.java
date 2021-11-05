package me.double8.admin.member.controller;

import lombok.RequiredArgsConstructor;
import me.double8.admin.login.Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class MemberController {

    private final Login login;

}
