package com.blackboard.canvas.service;

import java.util.List;

import com.blackboard.canvas.model.Assignment;
import com.blackboard.canvas.model.AssignmentSubmission;
import com.blackboard.canvas.model.Course;
import com.blackboard.canvas.model.Discussion;
import com.blackboard.canvas.model.Enrollment;

public interface InstructorService {

	public Assignment uploadAssignment(Assignment assignment);
	
	public Course uploadCourseMaterial(Course course);
	
	public Assignment gradeAssignment(Assignment grade);
	
	public Discussion startDiscussion(Discussion discussion);
	
	public List<Enrollment> enrollments(Course course);
	
	public List<AssignmentSubmission> getAssignmentSubmissions(Course course);
}
