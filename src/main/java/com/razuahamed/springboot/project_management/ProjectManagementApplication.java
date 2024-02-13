package com.razuahamed.springboot.project_management;

import com.razuahamed.springboot.project_management.repository.MemberRepository;
import com.razuahamed.springboot.project_management.repository.TaskRepository;
import com.razuahamed.springboot.project_management.repository.TeamRepository;
import com.razuahamed.springboot.project_management.service.TaskService;
import com.razuahamed.springboot.project_management.service.TeamService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjectManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(String[] args, TeamService teamService, TeamRepository teamRepository, TaskRepository taskRepository, MemberRepository memberRepository, TaskService taskService) {
		return runner -> {
			System.out.println("Okay");
//			System.out.println(teamService.getTeamWithName("Firmware"));
//			System.out.println("\n\n");
//			System.out.println(teamService.getTeamHaveMaxAverageAge());
//			System.out.println("\n\n");
//			System.out.println(teamService.teamWithMaxMember());
//			System.out.println("\n\nTask with Team and Member name");
//			taskService.getTaskWithTeamAndMember();
//			System.out.println("\n\n");
//			System.out.println("\n\nTask with Member name");
//			taskService.getTaskWithMember();
		};
	}
}
