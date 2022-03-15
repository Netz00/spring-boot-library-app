package com.netz00.libraryapp.service;

import com.netz00.libraryapp.domain.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();

    public User findById(Long id);

    public User addNewUser(User user);

    public User deleteUser(Long id);

    public User patchUser(Long id, User user);
}
