package com.blackboard.canvas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blackboard.canvas.model.Assignment;
import com.blackboard.canvas.model.Course;


@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Integer>{

	public List<Assignment> findByCourseId(Course courseId);
}
