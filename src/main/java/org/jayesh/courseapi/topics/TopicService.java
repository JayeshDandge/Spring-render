package org.jayesh.courseapi.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    List<Topic> topicList = new ArrayList<>(Arrays.asList(
                            new Topic(1,"SpringFrameWork","SpringFrameWrokDescription"),
                            new Topic (2,"SpringBoot","SpringBootDescription"),
                            new Topic (3,"SpringMVC","SpringBootDescription")));

    public List<Topic> getAllTopics(){
        //
        // return topicList;
        List<Topic> topicList1 = new ArrayList<>();
        topicRepository.findAll().forEach(topicList1::add);//It will connect to the database get all the topics and we are converting each topic into the list
        return topicList1;
    }

    public Optional<Topic> getTopic(int id){
        //return topicList.get(id-1);
       return topicRepository.findById(id);
    }

//    public Topic addTopic(Topic topic){
//        topicList.add(topic);
//        return topicList.get(topicList.size() -1);
//    }

    public void addTopic(Topic topic){
       topicRepository.save(topic); // Save the topic to the database
    }

    public Topic updateTopic(Topic topic,int id){
       // topicList.set(id-1,topic);
        //return topicList.get(id-1);
        return topicRepository.save(topic);// Same 'save' function will save the topic repository
    }

    public void deleteTopic(int id){
        //topicList.remove(id-1);
        topicRepository.deleteById(id);
    }
}
