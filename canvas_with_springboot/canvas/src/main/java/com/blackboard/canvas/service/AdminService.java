package com.blackboard.canvas.service;

import java.util.List;

import com.blackboard.canvas.model.Course;
import com.blackboard.canvas.model.User;

public interface AdminService {
	
	public String updateRole(int userId, String role);
	
	public String deleteUser(User user);
	
	public String addCourse(Course course);
	
	public List<User> getAllStudents();
	
	public List<User> getAllInstructors();

}
