package com.blackboard.canvas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blackboard.canvas.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

}
