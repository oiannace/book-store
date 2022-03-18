package com.example.demo.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ThreadController {
    private final ThreadService threadService;

    @Autowired
    public ThreadController(ThreadService threadService){
        this.threadService = threadService;
    }

    //@RequestMapping(value = "/api/v1/Book/search")
    //public ForumThread searchBook(@RequestParam(value = "bname", required = false) String bname){
    //    return threadService.searchBook(bname);
    //}

    @RequestMapping(value = "/home/threads", method = RequestMethod.GET)
    public List<ForumThread> getThreads() {

        return threadService.getThreads();
    }

    @RequestMapping(value = "/home/threads", method = RequestMethod.DELETE)
    public void removeThread(@PathVariable("id") int id){

        threadService.removeThread(id);
    }

    @RequestMapping(value = "/home/threads", method = RequestMethod.POST)
    public void addThread(//@RequestParam(value = "num", required = false) int num,
                        @RequestParam(value = "threadName", required = false) String threadName){

        ForumThread thread = new ForumThread(threadName);
        threadService.addThread(thread);
    }

}
