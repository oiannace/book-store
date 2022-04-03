package com.oiannace.forumapi.controller;

import com.oiannace.forumapi.service.ThreadService;
import com.oiannace.forumapi.method.ForumThread;

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

    @GetMapping
    public List<ForumThread> getThreads() {
        return threadService.getThreads();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeThread(@PathVariable("id") int id){

        threadService.removeThread(id);
    }

    @PostMapping
    public void addThread(@RequestBody ForumThread thread){

        threadService.addThread(thread);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateThread(@PathVariable("id") int id, @RequestParam String threadName){
        threadService.updateThread(id, threadName);
    }
}
