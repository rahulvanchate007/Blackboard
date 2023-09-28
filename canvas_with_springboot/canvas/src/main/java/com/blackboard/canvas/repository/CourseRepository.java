package com.blackboard.canvas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blackboard.canvas.model.Course;
import com.blackboard.canvas.model.User;


@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

	public List<Course> findByInstructorId(User instructorId);
}
