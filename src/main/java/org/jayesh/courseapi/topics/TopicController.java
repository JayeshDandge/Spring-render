package org.jayesh.courseapi.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/Topics")
    public List<Topic> getTopicsList(){
       return topicService.getAllTopics();
    }

    @RequestMapping("/Topics/{id}")
    public Optional<Topic> getTopic(@PathVariable("id") int id){
       return topicService.getTopic(id);
    }

    @RequestMapping(method =RequestMethod.POST, value = "/Topics")
        public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
        }

    @RequestMapping(method = RequestMethod.PUT, value = "/Topics/{id}")
    public Topic updateTopic(@RequestBody Topic topic,@PathVariable int id){
        return topicService.updateTopic(topic,id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/Topics/{id}")
    public void deleteTopic(@PathVariable int id){
        topicService.deleteTopic(id);
    }
}
