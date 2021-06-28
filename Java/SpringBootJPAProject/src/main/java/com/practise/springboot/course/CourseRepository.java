package com.practise.springboot.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> {

	/**
	 * Spring Data JPA doesn't have all the possible CRUD operations. It only
	 * provides the basic functionalities. If any new parameter is to be used to
	 * search the database then a new method is to be declared in the interface
	 * and Spring Boot is going to implement it by itself.
	 * 
	 * The method name should follow the naming conventions: 1. Use Camel case
	 * 2. start with findBy 3. Class Name/Property, i.e., Topic in this case 4.
	 * Parameter Name, i.e., id in the case
	 * 
	 * Spring Boot is going to implement the method for you. :)
	 * 
	 * @param topicId
	 * @return
	 */
	public List<Course> findByTopicId(String topicId);

}
