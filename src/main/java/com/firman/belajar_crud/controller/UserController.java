package com.firman.belajar_crud.controller;

import com.firman.belajar_crud.entity.User;
import com.firman.belajar_crud.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import com.firman.belajar_crud.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);

    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteUser(@PathVariable Long id){
        userService.deleteUser(id);

       return new ApiResponse("Data berhasil dihapus");
    }
}
