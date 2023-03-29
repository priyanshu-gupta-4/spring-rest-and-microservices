package com.freecharge.in28minutes.socialmedia.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static List<User> users=new ArrayList<>();
    private static Integer usersCount=0;
     static {
         users.add(new User(++usersCount,"priyanshu", LocalDate.now().minusYears(21)));
         users.add(new User(++usersCount,"prayas", LocalDate.now().minusYears(22)));
         users.add(new User(++usersCount,"pooja", LocalDate.now().minusYears(22)));
         users.add(new User(++usersCount,"Archit", LocalDate.now().minusYears(22)));
     }

    public static List<User> findAll() {
        return users;
    }

    public static Optional<User> findById(int id){
        Predicate<? super User> predicate=user -> user.getId()==id;
        return users.stream().filter(predicate).findFirst();
    }

    public static User save(User user){
         user.setId(++usersCount);
         users.add(user);
         return user;
    }

    public static void deleteById(int id){
         Predicate<?super User> predicate=user->user.getId()==id;
         users.removeIf(predicate);
    }
}
