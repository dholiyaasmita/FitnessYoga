package com.fitnessyoga.userservice.controller;

import com.fitnessyoga.userservice.dto.RegisterRequest;
import com.fitnessyoga.userservice.dto.UserResponse;
import com.fitnessyoga.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {


    private UserService userService;

    @GetMapping("/{userId}")
        public ResponseEntity<UserResponse> getUserProfile(@PathVariable String userId){
            return ResponseEntity.ok(userService.getUserProfile(userId));
        }


    @PostMapping("/register")
        public ResponseEntity<UserResponse> register(@Valid @RequestBody RegisterRequest request){
        return ResponseEntity.ok(userService.register(request));

    }


}
