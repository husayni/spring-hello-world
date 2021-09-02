package com.example.springboot.DTO;

public class User {

    private int id;
    private String name;
    private Role role = Role.ADMIN;

    public User() {}

    public User(int id, String name, String role)
    {
        this.id = id;
        this.name = name;
        this.role = Role.valueOf(role);
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public Role getRole()
    {
        return role;
    }
}
