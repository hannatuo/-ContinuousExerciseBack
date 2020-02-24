package fi.academy.learningdiary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TopicController {
@Autowired
    private TopicRepository topicRepository;

    @GetMapping
    @RequestMapping("/topics")
    public Iterable<Topic> getTopics() {
        Iterable<Topic> topics = topicRepository.findAll();
        return topics;
    }

    @GetMapping
    @RequestMapping("/topics/{id}")
    public Topic haeIdlla(@PathVariable(name = "id", required = false)
                                    Integer id) {
        Topic topic = topicRepository.haeIdlla(id);
        return topic;
    }

    @DeleteMapping("/topics/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTopic(@PathVariable(name = "id", required = true) Integer id) {
        topicRepository.deleteById(id);
    }


    @PostMapping("/topics")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createTopic(@RequestBody Topic topic) {
        topicRepository.save(topic);
    }

    @PutMapping("/topics/{id}")
    public ResponseEntity updateTopic(@PathVariable int id, @RequestBody Topic updatedTopic) {
        try {
            topicRepository.save(updatedTopic);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (ObjectOptimisticLockingFailureException ex) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }


}
