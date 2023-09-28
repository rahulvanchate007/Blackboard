package com.blackboard.canvas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackboard.canvas.model.Assignment;
import com.blackboard.canvas.model.AssignmentSubmission;
import com.blackboard.canvas.model.Course;
import com.blackboard.canvas.model.Enrollment;
import com.blackboard.canvas.model.User;
import com.blackboard.canvas.repository.AssignmentRepository;
import com.blackboard.canvas.repository.AssignmentSubmissionRepository;
import com.blackboard.canvas.repository.CourseRepository;
import com.blackboard.canvas.repository.EnrollmentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private EnrollmentRepository enrollmentRepository;

	@Autowired
	private AssignmentRepository assignmentRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private AssignmentSubmissionRepository assignmentSubmissionRepository;

	@Override
	public Enrollment enrollment(Enrollment enrollment) {
		// TODO Auto-generated method stub
		System.out.println(enrollment.getCourseId() +" "+ enrollment.getStudentId());
		return enrollmentRepository.save(enrollment);
	}
	
	@Override
	public List<Assignment> getAssignments(Course courseId) {
		// TODO Auto-generated method stub
		return assignmentRepository.findByCourseId(courseId);
	}

	@Override
	public AssignmentSubmission submitAssignment(AssignmentSubmission assignmentSubmission) {
		// TODO Auto-generated method stub
		return assignmentSubmissionRepository.save(assignmentSubmission);
	}

	@Override
	public List<Course> getCourses(User user) {
		// TODO Auto-generated method stub
		return courseRepository.findAll();
	}

}
