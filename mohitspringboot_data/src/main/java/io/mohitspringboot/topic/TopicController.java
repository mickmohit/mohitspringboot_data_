package io.mohitspringboot.topic;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	
	@Autowired
	private TopicService topicser;
	
	@RequestMapping("/topicss")
	public String getAllTopics()
	{
		return "All Topics";
	}
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopic()
	{
		return topicser.getAllTopic();
	}
	
	@RequestMapping("/topics/{id}")
	public Optional<Topic> getTopic(@PathVariable  String id)
	{
		return topicser.getTopic(id);
	}

	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopics(@RequestBody Topic topic) 
	{
		topicser.addTopic(topic);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopics(@RequestBody Topic topic,@PathVariable  String id) 
	{
		topicser.updateTopic(topic,id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopics(@PathVariable  String id) 
	{
		topicser.deleteTopic(id);
	}
	
}
