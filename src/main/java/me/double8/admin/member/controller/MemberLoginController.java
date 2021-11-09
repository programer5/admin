package me.double8.admin.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.double8.admin.member.domain.Member;
import me.double8.admin.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberLoginController {

    private final MemberService memberService;

    @GetMapping("/member-login")
    public String loginPage(Model model) {

        model.addAttribute("member", new Member());

        return "login/loginPage";
    }

    @GetMapping("/member-save")
    public String joinMemberPage(Model model) {

        model.addAttribute("member", new Member());

        return "login/joinMemberShip";
    }

    @PostMapping("/member-save")
    public String saveMember(@ModelAttribute Member member) {

        memberService.joinMemberShip(member);

        return "redirect:/";
    }

    @PostMapping("/member-login")
    public String login(@ModelAttribute Member member, Model model) {
        Member loginMember = memberService.login(member);
        model.addAttribute("loginMember", loginMember);

        return "redirect:/";
    }

}
