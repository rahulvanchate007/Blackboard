package com.blackboard.canvas.model;

import java.util.Date;

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
public class AssignmentSubmission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer submissionId;
	
	@NonNull
	@ManyToOne
    @JoinColumn(name = "assignmentId")
	private Assignment assignmentId;
	
	@NonNull
	@ManyToOne
    @JoinColumn(name = "studentId")
	private User studentId;
	
	@Column
	private Date submissionDate;
	
	@Column
	private String submissionText;
	
	@Column
	private String grade;

	public Integer getSubmissionId() {
		return submissionId;
	}

	public void setSubmissionId(Integer submissionId) {
		this.submissionId = submissionId;
	}

	public Assignment getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(Assignment assignmentId) {
		this.assignmentId = assignmentId;
	}

	public User getStudentId() {
		return studentId;
	}

	public void setStudentId(User studentId) {
		this.studentId = studentId;
	}

	public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	public String getSubmissionText() {
		return submissionText;
	}

	public void setSubmissionText(String submissionText) {
		this.submissionText = submissionText;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

}
