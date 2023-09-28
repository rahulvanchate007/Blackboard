package com.blackboard.canvas.service;

import java.util.List;

import com.blackboard.canvas.model.Assignment;
import com.blackboard.canvas.model.AssignmentSubmission;
import com.blackboard.canvas.model.Course;
import com.blackboard.canvas.model.Enrollment;
import com.blackboard.canvas.model.User;

public interface StudentService {
	
	public Enrollment enrollment(Enrollment enrollment);
	
	public List<Assignment> getAssignments(Course courseId);
	
	public AssignmentSubmission submitAssignment(AssignmentSubmission assignmentSubmission);
	
	public List<Course> getCourses(User user);

}
