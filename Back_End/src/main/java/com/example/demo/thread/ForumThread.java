package com.example.demo.thread;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table
public class ForumThread
{
    @Id
    @SequenceGenerator(
            name = "thread_sequence",
            sequenceName = "thread_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "thread_sequence"
    )
    private int id;
    private String threadName;
    private LocalDate postDate;

    /**
     * Constructor for objects of class ForumThread
     */
    public ForumThread(){}
    public ForumThread(String threadName)
    {
        this.threadName = threadName;
        this.postDate = LocalDate.now();
    }
    public String getthreadName()
    {
        return threadName;
    }
    public LocalDate getpostDate()
    {
        return postDate;
    }
    public int getid() {return id;}
}
