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
public class Discussion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer discussionId;
	
	@NonNull
	@ManyToOne
    @JoinColumn(name = "courseId")
	private Course courseId;
	
	@Column
	private String threadTitle;
	
	@Column
	private String threadDescription;

	public Integer getDiscussionId() {
		return discussionId;
	}

	public void setDiscussionId(Integer discussionId) {
		this.discussionId = discussionId;
	}

	public Course getCourseId() {
		return courseId;
	}

	public void setCourseId(Course courseId) {
		this.courseId = courseId;
	}

	public String getThreadTitle() {
		return threadTitle;
	}

	public void setThreadTitle(String threadTitle) {
		this.threadTitle = threadTitle;
	}

	public String getThreadDescription() {
		return threadDescription;
	}

	public void setThreadDescription(String threadDescription) {
		this.threadDescription = threadDescription;
	}

}
