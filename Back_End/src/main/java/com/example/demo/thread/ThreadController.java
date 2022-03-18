package com.example.demo.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/threads")
public class ThreadController {
    private final ThreadService threadService;

    @Autowired
    public ThreadController(ThreadService threadService){
        this.threadService = threadService;
    }

    @RequestMapping(value = "/{id}")
    public ForumThread searchBook(@PathVariable(name = "id") int id){
        return threadService.searchThread(id);
    }

    //@RequestMapping(value = "/home/threads", method = RequestMethod.GET)
    @GetMapping
    public List<ForumThread> getThreads() {

        return threadService.getThreads();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeThread(@PathVariable("id") int id){

        threadService.removeThread(id);
    }

    //@RequestMapping(value = "/{home/threads}", method = RequestMethod.POST)
    @PostMapping
    public void addThread(@RequestBody ForumThread thread){

        //ForumThread thread = new ForumThread(threadName);
        threadService.addThread(thread);
    }

}
