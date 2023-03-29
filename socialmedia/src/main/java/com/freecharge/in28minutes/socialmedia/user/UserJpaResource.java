package com.freecharge.in28minutes.socialmedia.user;

import com.freecharge.in28minutes.socialmedia.posts.PostRepository;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import com.freecharge.in28minutes.socialmedia.posts.Post;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class UserJpaResource {

    private UserRepository userRepository;
    private PostRepository postRepository;
    public UserJpaResource(PostRepository postRepository,UserRepository userRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @GetMapping(path="/jpa/users")
    public List<User> retrieveAllUsers(){
        System.out.println(userRepository.findAll());
        return userRepository.findAll();
    }

    @GetMapping(path="/jpa/users/{id}")
    public EntityModel<User> retriveUser(@PathVariable int id){
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("id"+id);
        }
        User found=user.get();
        EntityModel<User> entityModel = EntityModel.of(found);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

    @PostMapping(path = "/jpa/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser=userRepository.save(user);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path="/jpa/users/{id}")
    public void deleteUser(@PathVariable int id){
        userRepository.deleteById(id);
    }

    @GetMapping(path="/jpa/users/{id}/posts")
    public List<Post> retrievePostForUser(@PathVariable int id){
        Optional<User> user=userRepository.findById(id);
        if(user.isEmpty()) throw new UserNotFoundException("id"+id);
        return user.get().getPosts();
    }

    @PostMapping(path="/jpa/users/{id}/posts")
    public ResponseEntity<Object> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post){
        Optional<User> user=userRepository.findById(id);
        if(user.isEmpty()) throw new UserNotFoundException("id"+id);
        post.setUser(user.get());
        Post savedPost=postRepository.save(post);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
//    @GetMapping(path="/hello")
//    public String helloworldi18n(){
//        Locale locale= LocaleContextHolder.getLocale();
//        return messageSource.getMessage("good.morning.message",null,"Default Message",locale);
//    }

}

