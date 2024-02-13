package com.razuahamed.springboot.project_management.controller;

import com.razuahamed.springboot.project_management.model.Member;
import com.razuahamed.springboot.project_management.repository.MemberRepository;
import com.razuahamed.springboot.project_management.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    private MemberRepository memberRepository;
    private MemberService memberService;

    public MemberController(MemberRepository memberRepository, MemberService memberService) {
        this.memberRepository = memberRepository;
        this.memberService = memberService;
    }

    @GetMapping("/add")
    public String addMemberOnTeam(Model model) {
        model.addAttribute("newMember", new Member());
        return "add-member";
    }

    @PostMapping("/add")
    public String addMember(Member member) {
        System.out.println(member);
        this.memberRepository.addMember(member);
        System.out.println(memberRepository.getMemberList());
        return "add-member-success";
    }

//    @GetMapping("/addMemberInProject")
//    public String addMemberInProject(Model model) {
//        model.addAttribute("memberWithNoTeam",memberService.memberListInNoTeam());
//        System.out.println(memberService.memberListInNoTeam());
//        return "member-with-no-team";
//    }

}
