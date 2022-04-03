package com.oiannace.forumapi.service;

import com.oiannace.forumapi.method.ForumThread;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ThreadService
{
    public List<ForumThread> getThreads();

    public void removeThread(int id);

    public void addThread(ForumThread thread);

    public void updateThread(int id, String threadName);
    public ForumThread searchThread(int id);
}
