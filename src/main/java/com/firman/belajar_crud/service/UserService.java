package com.firman.belajar_crud.service;

import com.firman.belajar_crud.entity.User;
import com.firman.belajar_crud.exception.UserNotFoundException;
import com.firman.belajar_crud.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user){
        User existingUser = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User Tidak ditemukan"));

        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());

        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id){
        User exisitingUser = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User tidak ditemukan"));

        userRepository.delete(exisitingUser);
    }
}