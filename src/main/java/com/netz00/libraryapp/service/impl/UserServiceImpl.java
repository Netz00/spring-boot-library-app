package com.netz00.libraryapp.service.impl;

import com.netz00.libraryapp.domain.User;
import com.netz00.libraryapp.repository.UserRepository;
import com.netz00.libraryapp.service.UserService;
import com.netz00.libraryapp.exception.UserDoesNotExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) throws UserDoesNotExistsException {
        return userRepository.findById(id).orElseThrow(() -> new UserDoesNotExistsException(id));
    }

    @Override
    public User addNewUser(User author) {
        return userRepository.save(author);
    }

    @Override
    public User deleteUser(Long id) throws UserDoesNotExistsException {
        User author = userRepository.findById(id).orElseThrow(() -> new UserDoesNotExistsException(id));
        userRepository.delete(author);
        return author;
    }

    @Override
    public User patchUser(Long id, User author) throws UserDoesNotExistsException {
        User currentUser = userRepository.findById(id).orElseThrow(() -> new UserDoesNotExistsException(id));

        if (author.getName() != null) currentUser.setName(author.getName());

        if (author.getFamily_name() != null) currentUser.setFamily_name(author.getFamily_name());


        if (author.getAddress() != null) currentUser.setAddress(author.getAddress());

        if (author.getDate_birth() != null) currentUser.setDate_birth(author.getDate_birth());

        if (author.getDate_joining() != null) currentUser.setDate_joining(author.getDate_joining());

        if (author.getLast_modified_date() != null) currentUser.setLast_modified_date(author.getLast_modified_date());

        if (author.getEmail() != null) currentUser.setEmail(author.getEmail());

        if (author.getMobile() != null) currentUser.setMobile(author.getMobile());

        if (author.getNote() != null) currentUser.setNote(author.getNote());

        return userRepository.save(currentUser);

    }
}
