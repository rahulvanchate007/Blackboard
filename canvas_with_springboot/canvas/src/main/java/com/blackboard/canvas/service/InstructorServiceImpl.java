package com.blackboard.canvas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackboard.canvas.model.Assignment;
import com.blackboard.canvas.model.AssignmentSubmission;
import com.blackboard.canvas.model.Course;
import com.blackboard.canvas.model.Discussion;
import com.blackboard.canvas.model.Enrollment;
import com.blackboard.canvas.repository.AssignmentRepository;
import com.blackboard.canvas.repository.AssignmentSubmissionRepository;
import com.blackboard.canvas.repository.CourseRepository;
import com.blackboard.canvas.repository.DiscussionRepository;
import com.blackboard.canvas.repository.EnrollmentRepository;
import com.blackboard.canvas.repository.UserRepository;

@Service
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AssignmentRepository assignmentRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private DiscussionRepository discussionRepository;

	@Autowired
	private EnrollmentRepository enrollmentRepository;

	@Autowired
	private AssignmentSubmissionRepository assignmentSubmissionRepository;

	@Override
	public Assignment uploadAssignment(Assignment assignment) {
		// TODO Auto-generated method stub
		return assignmentRepository.save(assignment);
	}

	@Override
	public Course uploadCourseMaterial(Course course) {
		// TODO Auto-generated method stub
		return courseRepository.save(course);
	}

	@Override
	public Assignment gradeAssignment(Assignment assignment) {
		// TODO Auto-generated method stub
		for (Assignment existingAssignment : assignmentRepository.findAll()) {
			if (existingAssignment.getAssignmentId() == assignment.getAssignmentId()) {
				assignment.setAssignmentId(existingAssignment.getAssignmentId());
				assignment.setAssignmentName(existingAssignment.getAssignmentName());
				assignment.setAssignmentDate(existingAssignment.getAssignmentDate());
			}
		}
		return assignmentRepository.save(assignment);
	}

	@Override
	public Discussion startDiscussion(Discussion discussion) {
		// TODO Auto-generated method stub
		return discussionRepository.save(discussion);
	}

	@Override
	public List<AssignmentSubmission> getAssignmentSubmissions(Course course) {
		List<AssignmentSubmission> assignmentSubmissions = assignmentSubmissionRepository.findAll().stream()
				.filter(submission -> {
					Assignment assignment = submission.getAssignmentId();
					return assignment != null && assignment.getCourseId().getCourseId() == course.getCourseId();
				}).collect(Collectors.toList());
		return assignmentSubmissions;
	}

	@Override
	public List<Enrollment> enrollments(Course course) {
		// TODO Auto-generated method stub
		List<Enrollment> enrollments = enrollmentRepository.findAll().stream()
				.filter(enrollment -> {
					Course insCourse = enrollment.getCourseId();
					return insCourse != null && insCourse.getCourseId() == course.getCourseId();
				}).collect(Collectors.toList());
		return enrollments;
	}

}
