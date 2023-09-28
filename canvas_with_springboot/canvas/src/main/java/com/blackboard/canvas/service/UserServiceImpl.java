package com.blackboard.canvas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.blackboard.canvas.model.Course;
import com.blackboard.canvas.model.Discussion;
import com.blackboard.canvas.model.DiscussionPosts;
import com.blackboard.canvas.model.User;
import com.blackboard.canvas.repository.CourseRepository;
import com.blackboard.canvas.repository.DiscussionPostsRepository;
import com.blackboard.canvas.repository.DiscussionRepository;
import com.blackboard.canvas.repository.UserRepository;
import com.blackboard.canvas.util.JwtUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private final UserRepository userRepository;

	@Autowired
	private final CourseRepository courseRepository;

	@Autowired
	private final DiscussionRepository discussionRepository;

	@Autowired
	private final DiscussionPostsRepository discussionPostsRepository;

	private final JwtUtil jwtUtil;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, CourseRepository courseRepository,
			DiscussionRepository discussionRepository, DiscussionPostsRepository discussionPostsRepository,
			JwtUtil jwtUtil) {
		super();
		this.userRepository = userRepository;
		this.courseRepository = courseRepository;
		this.discussionRepository = discussionRepository;
		this.discussionPostsRepository = discussionPostsRepository;
		this.jwtUtil = jwtUtil;
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public ResponseEntity<String> login(User loginUser) {
		// TODO Auto-generated method stub
		User user = userRepository.findByEmail(loginUser.getEmail());
		if (user != null && loginUser.getPassword().equals(user.getPassword())) {
			String token = jwtUtil.generateToken(user.getRole(), user.getId());
			return ResponseEntity.ok(token);
		} else {
			return ResponseEntity.badRequest().body("Failed");
		}
	}

	@Override
	public User updateProfile(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<Course> getCourses(User userId) {
		// TODO Auto-generated method stub
		return courseRepository.findByInstructorId(userId);
	}

	@Override
	public List<DiscussionPosts> getDiscussionPosts(Course course) {
		// TODO Auto-generated method stub
		List<DiscussionPosts> discussionPosts = discussionPostsRepository.findAll().stream().filter(posts -> {
			Discussion discussion = posts.getDiscussionId();
			return discussion != null && discussion.getCourseId().getCourseId() == course.getCourseId();
		}).collect(Collectors.toList());
		return discussionPosts;
	}

	@Override
	public DiscussionPosts replyToDiscussion(DiscussionPosts discussionPosts) {
		// TODO Auto-generated method stub
		return discussionPostsRepository.save(discussionPosts);
	}
}
