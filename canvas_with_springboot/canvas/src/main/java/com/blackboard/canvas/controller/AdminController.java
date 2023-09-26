package com.blackboard.canvas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blackboard.canvas.model.Course;
import com.blackboard.canvas.model.User;
import com.blackboard.canvas.service.AdminService;
import com.blackboard.canvas.service.UserService;
import com.blackboard.canvas.util.UpdateRolePojo;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/addInstructor")
	public String addInstructor(@RequestBody User user) {
		user.setRole("instructor");
		userService.saveUser(user);
		return "Instructor Added";
	}
	
	@PostMapping("/addCourse")
	public String addCourse(@RequestBody Course course) {
		adminService.addCourse(course);
		return "Course Added";
	}

	@PostMapping("/updateRole")
	public String updateRole(@RequestBody UpdateRolePojo updateRolePojo) {
		adminService.updateRole(updateRolePojo.getUserId(), updateRolePojo.getRole());
		return "Role Updated";
	}
	
	@PostMapping("/deleteUser")
	public String deleteUser(@RequestBody User user) {
		adminService.deleteUser(user);
		return "User Deleted";
	}	
	
	@GetMapping("/getAllStudents")
	public List<User> getAllStudents() {
		return adminService.getAllStudents();
	}
	
	@GetMapping("/getAllInstructors")
	public List<User> getAllInstructors() {
		return adminService.getAllInstructors();
	}
	
}
