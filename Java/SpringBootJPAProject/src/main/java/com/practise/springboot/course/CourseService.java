package com.practise.springboot.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Identifies this class as a Spring Boot Business Service. Spring maintains a
 * singleton instance of all Business Service classes
 * 
 * @author ranja
 *
 */
@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getAllCourses(String topicId) {
		List<Course> courses = new ArrayList<>();
		/**
		 * forEach is used in Java 8 lambda expressions where <Type>::<method
		 * contained in the Type>. This lines iterates on all the topics and
		 * adds them to the list of topics by calling the add method of topics
		 * variable.
		 */
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}

	public Course getCourse(String id) {
		return courseRepository.findById(id).get();
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {
		/**
		 * The save method of the CrudRepository can handle both insert and
		 * update. If the id provide doesn't exists then it makes an insert
		 * otherwise an update.
		 */
		courseRepository.save(course);
	}

	public void deleteCourse(String id) {
		/**
		 * removes all the Topics from the list if the predicate return multiple
		 * or one Topic
		 */
		courseRepository.deleteById(id);
	}
}
