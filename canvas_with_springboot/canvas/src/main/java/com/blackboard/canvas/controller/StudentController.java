package com.blackboard.canvas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blackboard.canvas.model.Assignment;
import com.blackboard.canvas.model.AssignmentSubmission;
import com.blackboard.canvas.model.Course;
import com.blackboard.canvas.model.Enrollment;
import com.blackboard.canvas.model.User;
import com.blackboard.canvas.service.StudentService;

@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/enrollCourse")
	public String enrollCourse(@RequestBody Enrollment enrollment) {
		studentService.enrollment(enrollment);
		return "Course Enrolled";
	}
	
	@GetMapping("/getAssignments")
	public List<Assignment> getAssignments(@RequestBody Course course) {
		return studentService.getAssignments(course);
		
	}
	
	@PostMapping("/submitAssignment")
	public String submitAssignment(@RequestBody AssignmentSubmission assignmentSubmission) {
		studentService.submitAssignment(assignmentSubmission);
		return "Assignment response submitted";
	}
	
	@GetMapping("/getCourses")
	public List<Course> getCourses(User user) {
		return studentService.getCourses(user);
	}
}
