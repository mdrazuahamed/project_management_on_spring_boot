package com.razuahamed.springboot.project_management.controller;

import com.razuahamed.springboot.project_management.model.Member;
import com.razuahamed.springboot.project_management.model.Task;
import com.razuahamed.springboot.project_management.model.Team;
import com.razuahamed.springboot.project_management.repository.MemberRepository;
import com.razuahamed.springboot.project_management.repository.TaskRepository;
import com.razuahamed.springboot.project_management.repository.TeamRepository;
import com.razuahamed.springboot.project_management.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/task")
public class TaskController {
    private TaskRepository taskRepository;
    private MemberRepository memberRepository;
    private MemberService memberService;
    private TeamRepository teamRepository;
    public TaskController(TaskRepository taskRepository, MemberService memberService, MemberRepository memberRepository, TeamRepository teamRepository) {
        this.taskRepository = taskRepository;
        this.memberService = memberService;
        this.memberRepository = memberRepository;
        this.teamRepository = teamRepository;
    }

    @GetMapping("/addTask")
    public String addTask(Model model,@RequestParam("teamId") long teamId){
        model.addAttribute("memberWithNoTask",memberService.memberListInNoTeam());
        model.addAttribute("teamId", teamId);
        return "add-task";
    }

    @PostMapping("/addTaskOnProject")
    public String addTaskOnProject(@RequestParam("teamId") long teamId, @RequestParam("taskName") String taskName, @RequestParam("memberName") String memberName){
        Member member = memberRepository.getMemberByName(memberName);
        Task task = taskRepository.addAndGetTaskWithName(taskName,member);
        Team team = teamRepository.getTeamById(teamId);
        team.addTask(task);

        return "add-task-success";
    }
}
