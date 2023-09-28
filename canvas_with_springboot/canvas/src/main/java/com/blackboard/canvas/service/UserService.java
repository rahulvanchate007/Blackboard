package com.blackboard.canvas.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.blackboard.canvas.model.Course;
import com.blackboard.canvas.model.DiscussionPosts;
import com.blackboard.canvas.model.User;

public interface UserService {

	public User saveUser(User user);
	
	public ResponseEntity<String> login(User user);

	public User updateProfile(User user);
	
	public List<Course> getCourses(User userId);
	
	public List<DiscussionPosts> getDiscussionPosts(Course course);
	
	public DiscussionPosts replyToDiscussion(DiscussionPosts discussionPosts);
}
