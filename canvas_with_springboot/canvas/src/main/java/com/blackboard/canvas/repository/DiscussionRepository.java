package com.blackboard.canvas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blackboard.canvas.model.Discussion;

@Repository
public interface DiscussionRepository extends JpaRepository<Discussion, Integer>{

}
