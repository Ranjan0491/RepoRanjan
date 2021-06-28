package com.practise.springboot.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practise.springboot.topic.Topic;

/**
 * This annotation RestController is used to build a REST service using Spring
 * Boot
 **/
@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	/**
	 * RequestMapping annotation identifies the URI
	 * 
	 * @return
	 */
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getCourses(@PathVariable String topicId) {
		return courseService.getAllCourses(topicId);
	}

	/**
	 * RequestMapping annotation identifies the URI
	 * 
	 * PathVariable identifies the variable in the curly braces as an input to
	 * the HTTP method call
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}

	/**
	 * Since the default HTTP method is GET, there is a need to specify the
	 * method param if HTTP method POST is required to be configured. also the
	 * value param identifies the URI
	 * 
	 * RequestBody annotation tells the Spring Boot framework that the request
	 * body should contain a type (Topic is the type in this case) in Jason
	 * format
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}

	/**
	 * Since the default HTTP method is GET, there is a need to specify the
	 * method param if HTTP method PUT is required to be configured. also the
	 * value param identifies the URI
	 * 
	 * RequestBody annotation tells the Spring Boot framework that the request
	 * body should contain a type (Topic is the type in this case) in Jason
	 * format
	 * 
	 * Also the PathVariable annotation should be present to identify the topic
	 * that is required to be updated
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
	}

	/**
	 * Since the default HTTP method is GET, there is a need to specify the
	 * method param if HTTP method DELETE is required to be configured. also the
	 * value param identifies the URI
	 * 
	 * Also the PathVariable annotation should be present to identify the topic
	 * that is required to be updated
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
	}

}
