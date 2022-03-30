package com.oiannace.forumapi.repository;

import com.oiannace.forumapi.payload.ForumThread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ThreadRepository extends JpaRepository<ForumThread,Integer> {

    @Query("SELECT t FROM ForumThread t WHERE t.id = ?1")
    Optional<ForumThread> findThreadbyid(int id);

    @Modifying
    @Query("UPDATE ForumThread t set t.threadName = ?1 where t.id = ?2")
    void setthreadNamebyId(String threadName, int id);
}
