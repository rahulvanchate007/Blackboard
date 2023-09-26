package com.blackboard.canvas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackboard.canvas.model.Course;
import com.blackboard.canvas.model.User;
import com.blackboard.canvas.repository.CourseRepository;
import com.blackboard.canvas.repository.UserRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public String updateRole(int userId, String role) {
		// TODO Auto-generated method stub

		userRepository.findAll()
	    .stream()
	    .filter(user -> user.getId() == userId)
	    .findFirst()
	    .ifPresent(user -> {
	        user.setRole(role);
	        userRepository.save(user);
	    });
		return "Role Updated";
	}

	@Override
	public String deleteUser(User user) {
		// TODO Auto-generated method stub
		
		userRepository.deleteById(user.getId());
		return "User Deleted";
	}

	@Override
	public String addCourse(Course course) {
		// TODO Auto-generated method stub
		courseRepository.save(course);
		return "Course Added";
	}

	@Override
	public List<User> getAllStudents() {
		// TODO Auto-generated method stub
		return userRepository.findAll()
			    .stream()
			    .filter(user -> "student".equals(user.getRole()))
			    .collect(Collectors.toList());
	}

	@Override
	public List<User> getAllInstructors() {
		// TODO Auto-generated method stub
		return userRepository.findAll()
			    .stream()
			    .filter(user -> "instructor".equals(user.getRole()))
			    .collect(Collectors.toList());
	}

}
