package com.blackboard.canvas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blackboard.canvas.model.DiscussionPosts;

@Repository
public interface DiscussionPostsRepository extends JpaRepository<DiscussionPosts, Integer>{

}
