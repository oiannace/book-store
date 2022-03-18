package com.example.demo.thread;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ThreadRepository extends JpaRepository<ForumThread,Integer> {

    @Query("SELECT t FROM ForumThread t WHERE t.id = ?1")
    Optional<ForumThread> findThreadbyid(int id);
}
