package io.mohitspringboot.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository tr;
	
	private List<Topic> topics= new ArrayList<>( Arrays.asList(
			new Topic("spring","spring framework","SFD"),
			new Topic("Java","Core Java framework","SFD"),
			new Topic("Javascript","JS framework","SFD")
			));
	
	public List<Topic> getAllTopic()
	{
		//return topics;
		List<Topic> topics= new ArrayList<>();
		tr.findAll().forEach(topics::add);
		return topics;
	}

	public Optional<Topic> getTopic(String id)
	{
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return tr.findById(id);
	}

	public void addTopic(Topic topic) {
		// TODO Auto-generated method stub
	//topics.add(topic);	
	tr.save(topic);
	}

	public void updateTopic(Topic topic, String id) {
		// TODO Auto-generated method stub
		/*for(int i=0;i<topics.size();i++)
		{
			Topic t=topics.get(i);
			if(t.getId().equals(id))
			{
				topics.set(i, topic);
				return;
			}
		}*/
		tr.save(topic);
		
	}

	public void deleteTopic(String id) {
		// TODO Auto-generated method stub
		//topics.removeIf(t->t.getId().equals(id));
		tr.deleteById(id);
	}
	
}
