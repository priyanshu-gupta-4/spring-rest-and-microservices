package com.freecharge.in28minutes.socialmedia.user;

import jakarta.validation.Valid;
import jdk.jfr.Description;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class UserResource {

    private UserDaoService userDaoService;

    public UserResource(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping(path="/users")
    public List<User> retrieveAllUsers(){
        return userDaoService.findAll();
    }

    @GetMapping(path="/users/{id}")
    public EntityModel<User> retriveUser(@PathVariable int id){
        Optional<User> user = userDaoService.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("id"+id);
        }
        User found=user.get();
        EntityModel<User> entityModel = EntityModel.of(found);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

    @PostMapping(path = "/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser=userDaoService.save(user);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path="/users/{id}")
    public void deleteUser(@PathVariable int id){
        userDaoService.deleteById(id);
    }

//    @GetMapping(path="/hello")
//    public String helloworldi18n(){
//        Locale locale= LocaleContextHolder.getLocale();
//        return messageSource.getMessage("good.morning.message",null,"Default Message",locale);
//    }

}
