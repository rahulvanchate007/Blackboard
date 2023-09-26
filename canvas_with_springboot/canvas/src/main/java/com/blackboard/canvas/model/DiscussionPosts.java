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
public class DiscussionPosts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer postId;
	
	@NonNull
	@ManyToOne
    @JoinColumn(name = "discussionId")
	private Discussion discussionId;
	
	@NonNull
	@ManyToOne
    @JoinColumn(name = "userId")
	private User userId;
	
	@Column
	private String postText;

	@Column
	private Date postDate;

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public Discussion getDiscussionId() {
		return discussionId;
	}

	public void setDiscussionId(Discussion discussionId) {
		this.discussionId = discussionId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	
}
