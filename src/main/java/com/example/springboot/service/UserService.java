package com.example.springboot.service;
import com.example.springboot.DTO.User;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class UserService {

    private List<User> userList;

    public UserService()
    {
        userList = new ArrayList<User>();
        userList.add(new User(1,"Hussain","ADMIN"));
        userList.add(new User(2,"Fahad","GUEST"));
        userList.add(new User(3,"Kabir","GUEST"));
        userList.add(new User(4,"Sami","GUEST"));
    }

    public List<User> getUserList()
    {
        return userList;
    }

    public void addUser(User user)
    {
        userList.add(user);
    }

    public Optional<User> updateUser(User user)
    {
        userList = userList.stream()
                .map(
                        u ->
                        {
                            if (user.getId() == u.getId())
                            {
                                return user;
                            }
                            return u;
                        })
                .collect(Collectors.toList());

        return userList.stream()
                .filter(u -> u.getId() == user.getId())
                .findFirst();
    }

    public Optional<User> getUser(int userId)
    {
        return userList.stream()
                .filter(u -> u.getId() == userId)
                .findFirst();
    }
}
