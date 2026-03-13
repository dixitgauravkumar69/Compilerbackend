package com.example.POD.Controller;

import com.example.POD.DTO.UserDTO;
import com.example.POD.DTO.UserLoginDTO;
import com.example.POD.Entity.ProblemStatement;
import com.example.POD.Entity.UserEntity;
import com.example.POD.Repository.UserRepository;
import com.example.POD.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/User")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepo;

    @PostMapping("/addUser")
    public UserDTO addUser(@RequestBody UserDTO user)
    {
       UserDTO createdUser= userService.addUser(user);
       return createdUser;
    }

    @PostMapping("/login")
 public UserDTO loginUser(@RequestBody UserLoginDTO userLoginDTO)
    {
        UserDTO loggedInUser=userService.loginUser(userLoginDTO);
        return loggedInUser;
    }

    @GetMapping("/getProblemStatements")
    public List<ProblemStatement> getProblemStatements()
    {
      List< ProblemStatement>  ps= userService.getProblemStatements();
       return ps;
    }

    @GetMapping("/profile")
    public UserEntity getProfile(@RequestParam String email)
    {
        UserEntity user=userRepo.findByUserEmail(email);
        return user;
    }
}
