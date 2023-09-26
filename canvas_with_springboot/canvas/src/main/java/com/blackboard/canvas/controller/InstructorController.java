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
import com.blackboard.canvas.model.Discussion;
import com.blackboard.canvas.model.Enrollment;
import com.blackboard.canvas.service.InstructorService;

@CrossOrigin
@RestController
@RequestMapping("/instructor")
public class InstructorController {
	
	@Autowired
	private InstructorService instructorService;
	
	@PostMapping("/uploadAssignment")
	public Assignment uploadAssignment(@RequestBody Assignment assignment) {
		return instructorService.uploadAssignment(assignment);
	}
	
	@PostMapping("/startDiscussion")
	public Discussion startDiscussion(@RequestBody Discussion discussion)  {
		return instructorService.startDiscussion(discussion);
	}
	
	@GetMapping("/enrollments")
	public List<Enrollment> enrollments(@RequestBody Course course) {
		return instructorService.enrollments(course);
	}
	
	@PostMapping("/uploadCourseMaterial")
	public Course uploadCourseMaterial(@RequestBody Course course) {
		return instructorService.uploadCourseMaterial(course);
	}
	
	@PostMapping("/gradeAssignment")
	public Assignment gradeAssignment(@RequestBody Assignment assignment) {
		return instructorService.gradeAssignment(assignment);
	}
	
	@GetMapping("/getAssignmentSubmissions")
	public List<AssignmentSubmission> getAssignmentSubmissions(@RequestBody Course course) {
		return instructorService.getAssignmentSubmissions(course);
	}
	
}
