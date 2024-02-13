package com.razuahamed.springboot.project_management.controller;

import com.razuahamed.springboot.project_management.model.Member;
import com.razuahamed.springboot.project_management.model.Team;
import com.razuahamed.springboot.project_management.service.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/team")
public class TeamController {
    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/maxMember")
    public String showTeamWithMaximumMember(Model model) {
        Team team = teamService.teamWithMaxMember();
        model.addAttribute("maxTeam", team);
        return "max-team";
    }

    @GetMapping("/allTeam")
    public String showAllTeam(Model model) {
        List<Team> teamList = teamService.getAllTeam();
        System.out.println(teamList);
        model.addAttribute("allTeam", teamList);
        return "all-team";
    }
}
