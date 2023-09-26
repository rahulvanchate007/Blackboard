package com.blackboard.canvas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table
public class Enrollment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer enrollmentId;
	
	@NonNull
	@ManyToOne
    @JoinColumn(name = "studentId")
	private User studentId;
	
	@NonNull
	@ManyToOne
    @JoinColumn(name = "courseId")
	private Course courseId;

	public Integer getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(Integer enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public User getStudentId() {
		return studentId;
	}

	public void setStudentId(User studentId) {
		this.studentId = studentId;
	}

	public Course getCourseId() {
		return courseId;
	}

	public void setCourseId(Course courseId) {
		this.courseId = courseId;
	}

	
}
