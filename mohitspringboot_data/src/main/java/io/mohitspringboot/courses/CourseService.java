package io.mohitspringboot.courses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository cr;
	
	/*private List<Course> topics= new ArrayList<>( Arrays.asList(
			new Course("spring","spring framework","SFD"),
			new Course("Java","Core Java framework","SFD"),
			new Course("Javascript","JS framework","SFD")
			));*/
	
	public List<Course> getAllCourses(String topicId)
	{
		//return topics;
		List<Course> courses= new ArrayList<>();
		cr.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}

	public Optional<Course> getCourse(String id)
	{
		//return topics.scream().filter(t -> t.getId().equals(id)).findFirst().get();
		return cr.findById(id);
	}

	public void addCourse(Course course) {
		// TODO Auto-generated method stub
	//topics.add(topic);	
	cr.save(course);
	}

	public void updateCourse(Course course) {
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
		cr.save(course);
		
	}

	public void deleteCourse(String id) {
		// TODO Auto-generated method stub
		//topics.removeIf(t->t.getId().equals(id));
		cr.deleteById(id);
	}
	
}
