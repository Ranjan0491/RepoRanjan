package com.practise.springboot.topic;

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
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
	// private List<Topic> topics = new ArrayList<>(
	// Arrays.asList(new Topic("Spring", "SpringBoot", "Learning Spring Boot"),
	// new Topic("Java", "Core Java", "Learning Core Java"),
	// new Topic("DB", "Oracle", "Learning Oracle DB"), new Topic("JavaScript",
	// "Angular JS", "Learning angular JS")));

	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>();
		/**
		 * forEach is used in Java 8 lambda expressions where <Type>::<method
		 * contained in the Type>. This lines iterates on all the topics and
		 * adds them to the list of topics by calling the add method of topics
		 * variable.
		 */
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}

	public Topic getTopic(String id) {
		/**
		 * 1. Converts the list of topics into a stream 2. matches each of the
		 * id with the given id 3. finds the first match 4. gets the topic
		 */
		// return topics.stream().filter(t ->
		// t.getId().equals(id)).findFirst().get();
		return topicRepository.findById(id).get();
	}

	public void addTopic(Topic topic) {
		// topics.add(topic);
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		/**
		 * The save method of the CrudRepository can handle both insert and
		 * update. If the id provide doesn't exists then it makes an insert
		 * otherwise an update.
		 */
		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
		/**
		 * removes all the Topics from the list if the predicate return multiple
		 * or one Topic
		 */
		// topics.removeIf(t -> t.getId().equals(id));
		topicRepository.deleteById(id);
	}
}
