package com.example.demo.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThreadService
{
    private final ThreadRepository threadRepository;

    @Autowired
    public ThreadService(ThreadRepository threadRepository)
    {
        this.threadRepository = threadRepository;
    }

    public List<ForumThread> getThreads(){
        return threadRepository.findAll();
    }

    public void removeThread(int id){
        boolean tid = threadRepository.existsById(id);
        if(!tid){
            throw new IllegalStateException("Book with id "+ id + " does not exist");
        }
        threadRepository.deleteById(id);
    }

    public void addThread(ForumThread thread){
        Optional<ForumThread> threadOptional = threadRepository.findThreadbyid(thread.getid());
        threadRepository.save(thread);
    }

    public void updateThread(int id, String threadName){
        Optional<ForumThread> threadOptional = threadRepository.findThreadbyid(id);
        if(!threadOptional.isPresent()){
            ForumThread thread = new ForumThread(threadName);
            threadRepository.save(thread);
        }
        else{
            ForumThread thread = threadOptional.get();
            thread.setthreadName(threadName);
            threadRepository.save(thread);
        }
    }
    public ForumThread searchThread(int id) {
        Optional<ForumThread> threadOptional = threadRepository.findThreadbyid(id);
        if(!threadOptional.isPresent()){
            throw new IllegalStateException("Thread does not exist.");
        }
        ForumThread thread = threadOptional.get();
        return thread;
    }
}
