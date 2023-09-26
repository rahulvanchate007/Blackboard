package com.blackboard.canvas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blackboard.canvas.model.Assignment;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Integer>{

}
