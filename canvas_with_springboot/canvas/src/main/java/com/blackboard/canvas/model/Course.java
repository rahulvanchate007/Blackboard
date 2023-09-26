package com.blackboard.canvas.model;

import javax.persistence.Column;
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
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer courseId;
	
	@Column
	private String courseName;
	
	@Column
	private String courseMaterial;
	
	@NonNull
	@ManyToOne
    @JoinColumn(name = "instructorId")
	private User instructorId;

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseMaterial() {
		return courseMaterial;
	}

	public void setCourseMaterial(String courseMaterial) {
		this.courseMaterial = courseMaterial;
	}

	public User getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(User instructorId) {
		this.instructorId = instructorId;
	}
	
}
