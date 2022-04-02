package com.oiannace.forumapi.configuration;

import com.oiannace.forumapi.payload.AppUser;
import com.oiannace.forumapi.payload.ForumThread;
import com.oiannace.forumapi.repository.AppUserRepository;
import com.oiannace.forumapi.repository.ThreadRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class ThreadConfig {
    @Bean
    CommandLineRunner commandLineRunner(ThreadRepository repo, AppUserRepository userrepo){
        return args->{
            ForumThread Book1 = new ForumThread ("The Hobbit");
            ForumThread Book2 = new ForumThread ("Eragon");
            ForumThread Book3 = new ForumThread ("Ornello");
            ArrayList<ForumThread> threads = new ArrayList<ForumThread>();
            threads.add(Book1);
            threads.add(Book2);
            threads.add(Book3);
            repo.saveAll(
                    threads
            );
        };
    }

}
