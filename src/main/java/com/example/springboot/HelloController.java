package com.example.springboot;
import com.example.springboot.DTO.User;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController()
public class HelloController {
    @Autowired
    public UserService userList;

    @GetMapping("/")
    public String Index()
    {
        return "Hello World";
    }

    @GetMapping("/user/{userId}")
    public Optional<User> getUser(@PathVariable Integer userId)
    {
        System.out.println(userId);
        return userList.getUser(userId);
    }

    @PutMapping("/user")
    public Optional<User> updateUser(@RequestBody User user)
    {
        return userList.updateUser(user);
    }

    @GetMapping("/users")
    public List<User> getUserList()
    {
        return userList.getUserList();
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user)
    {
        userList.addUser(user);
        return user;
    }
}
