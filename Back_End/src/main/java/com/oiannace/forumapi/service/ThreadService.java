package com.oiannace.forumapi.service;

import com.oiannace.forumapi.payload.ForumThread;
import com.oiannace.forumapi.repository.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ThreadService
{
    public List<ForumThread> getThreads();

    public void removeThread(int id);

    public void addThread(ForumThread thread);

    public void updateThread(int id, String threadName);
    public ForumThread searchThread(int id);
}
