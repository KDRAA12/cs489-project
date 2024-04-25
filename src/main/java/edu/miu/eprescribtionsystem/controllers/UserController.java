package edu.miu.eprescribtionsystem.controllers;


import edu.miu.eprescribtionsystem.Services.UserService;
import edu.miu.eprescribtionsystem.models.User;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public User save(@RequestBody User user){
        return userService.save(user);
    }


    @GetMapping
    public Page<User> findAll(Pageable pageable){
        return userService.findAll(pageable);
    }
}
