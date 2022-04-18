package com.oiannace.forumapi.method;

import javax.persistence.*;

@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;
    private AppUser user;
    private ForumThread thread;

    public Comment(String content){
        this.content = content;
    }

    public AppUser getUser() {
        return user;
    }

    public ForumThread getThread() {
        return thread;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public void setThread(ForumThread thread) {
        this.thread = thread;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
