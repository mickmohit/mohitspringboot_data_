package io.mohitspringboot.courses;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.mohitspringboot.topic.Topic;

@Entity
public class Course {

	@Id
	public String id;
	public String name;
	public String description;
	
	@ManyToOne
	private Topic topic;
	
	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Course() {}
	
	public Course(String id, String name, String description, String topicid ) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic=new Topic(topicid,"","");
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
