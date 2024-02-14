package com.razuahamed.springboot.project_management.controller;
import com.razuahamed.springboot.project_management.model.Member;
import com.razuahamed.springboot.project_management.model.Task;
import com.razuahamed.springboot.project_management.model.Team;
import com.razuahamed.springboot.project_management.repository.MemberRepository;
import com.razuahamed.springboot.project_management.repository.TaskRepository;
import com.razuahamed.springboot.project_management.repository.TeamRepository;
import com.razuahamed.springboot.project_management.service.MemberService;
import com.razuahamed.springboot.project_management.service.TaskService;
import com.razuahamed.springboot.project_management.service.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {
    TeamService teamService;
    private TaskRepository taskRepository;
    private MemberRepository memberRepository;
    private MemberService memberService;
    private TeamRepository teamRepository;

    public TaskController(TeamService teamService, TaskRepository taskRepository, MemberService memberService, MemberRepository memberRepository, TeamRepository teamRepository) {
        this.taskRepository = taskRepository;
        this.memberService = memberService;
        this.memberRepository = memberRepository;
        this.teamRepository = teamRepository;
        this.teamService = teamService;
    }

    @GetMapping("/addTask")
    public String addTask(Model model,@RequestParam("teamId") long teamId) {
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

    @GetMapping("/completeTask")
    public String completeTask(@RequestParam("taskId") long taskId, @RequestParam("teamId") long teamId) {
        Task taskToRemove = null;
        List<Task> tasksToRemove = new ArrayList<>();

        for (Task task : taskRepository.getTaskList()) {
            if (taskId == task.getId()) {
                taskToRemove = task;
                tasksToRemove.add(task);
            }
        }

        for (Task task : tasksToRemove) {
            taskRepository.getTaskList().remove(task);
        }

        teamService.removeTaskFromTeamById(taskToRemove, teamId);
        return "remove-complete-task";
    }

}
