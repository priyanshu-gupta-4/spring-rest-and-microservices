package com.freecharge.in28minutes.socialmedia.posts;

import com.freecharge.in28minutes.socialmedia.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {

}
