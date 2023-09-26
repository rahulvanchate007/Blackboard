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
		List<User> allUsers = userRepository.findAll();
		System.out.println(loginUser.getEmail() + loginUser.getPassword());
		for (User user : allUsers) {
			if (loginUser.getEmail().toString().equals(user.getEmail().toString())) {
				if (loginUser.getPassword().toString().equals(user.getPassword().toString())) {
					String token = jwtUtil.generateToken(user.getEmail());
					return ResponseEntity.ok(token);
				}
			}
		}
		return ResponseEntity.badRequest().body("Failed");
	}

	@Override
	public User updateProfile(User user) {
			return userRepository.save(user);
	}

	@Override
	public List<Course> getCourses(User user) {
		// TODO Auto-generated method stub
		return courseRepository.findAll()
				.stream()
				.filter(course -> course.getInstructorId().getId() == user.getId())
				.collect(Collectors.toList());
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
