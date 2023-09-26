package com.blackboard.canvas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blackboard.canvas.model.Course;
import com.blackboard.canvas.model.DiscussionPosts;
import com.blackboard.canvas.model.User;
import com.blackboard.canvas.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public String saveStudent(@RequestBody User user) {
		user.setRole("student");
		userService.saveUser(user);
		return "Registered User Sucessfully";
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User user) {
		return userService.login(user);
	}
	
	@PostMapping("/updateProfile")
	public String updateProfile(@RequestBody User user) {
		
		userService.saveUser(user);
		return "Profile Updated";
	}
	
	@GetMapping("/getCourses")
	public List<Course> getCourses(@RequestBody User user) {
		return userService.getCourses(user);
	}
	
	@GetMapping("/getDiscussionPosts")
	public List<DiscussionPosts> getDiscussionPosts(@RequestBody Course course) {
		return userService.getDiscussionPosts(course);
	}
	
	@PostMapping("/replyToDiscussion")
	public DiscussionPosts replyToDiscussion(@RequestBody DiscussionPosts discussionPosts) {
		return userService.replyToDiscussion(discussionPosts);
	}
	
}
