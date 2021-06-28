package com.practise.springboot.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * This annotation RestController is used to build a REST service using Spring
 * Boot
 **/
@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;

	/**
	 * RequestMapping annotation identifies the URI
	 * 
	 * @return
	 */
	@RequestMapping("/topics")
	public List<Topic> getTopics() {
		return topicService.getAllTopics();
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
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable(name = "id", required = true) String id) {
		return topicService.getTopic(id);
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
	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
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
	 * Also the PathVariable annotaion should be present to identify the topic
	 * that is required to be updated
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable(name = "id", required = true) String id) {
		topicService.updateTopic(id, topic);
	}

	/**
	 * Since the default HTTP method is GET, there is a need to specify the
	 * method param if HTTP method DELETE is required to be configured. also the
	 * value param identifies the URI
	 * 
	 * Also the PathVariable annotaion should be present to identify the topic
	 * that is required to be updated
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
	public void deleteTopic(@PathVariable(name = "id", required = true) String id) {
		topicService.deleteTopic(id);
	}

}
