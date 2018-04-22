package io.mohitspringboot.courses;

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

import io.mohitspringboot.topic.Topic;

@RestController
public class CourseController {

	
	@Autowired
	private CourseService courseser;
	
	@RequestMapping("/courses")
	public String getAllTopics()
	{
		return "All Topics";
	}
	
	@RequestMapping("/topics/{topicid}/course")
	public List<Course> getAllTopic(String topicid)
	{
		return courseser.getAllCourses(topicid);
	}
	
	@RequestMapping("/topics/{topicid}/course/{couserId}")
	public Optional<Course> getTopic(@PathVariable  String couserId)
	{
		return courseser.getCourse(couserId);
	}

	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicid}/course")
	public void addCourse(@RequestBody Course course,@PathVariable  String topicid) 
	{
		course.setTopic(new Topic(topicid,"",""));
		courseser.addCourse(course);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicid}/course/{courseId}")
	public void updateCourse(@RequestBody Course course,@PathVariable  String courseId, @PathVariable  String topicid) 
	{
		course.setTopic(new Topic(topicid,"",""));
		courseser.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicid}/course/{courseId}")
	public void deleteCourse(@PathVariable  String courseId) 
	{
		courseser.deleteCourse(courseId);
	}
	
}
