package com.bts.recruiting.controllers;

import com.bts.recruiting.dtos.UserDto;
import com.bts.recruiting.enums.UserDecision;
import com.bts.recruiting.enums.UserQueueLevel;
import com.bts.recruiting.servicies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> addUser(@RequestBody @Valid UserDto userDto) {
        UserDto responseUserDto = userService.addUser(userDto);
        return new ResponseEntity<>(responseUserDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserDto> addUserDecision(@PathVariable(name = "id") Integer userId,
                                                   @RequestParam UserDecision userDecision) {
        UserDto responseUserDto = userService.addUserDecision(userDecision, userId);
        return new ResponseEntity<>(responseUserDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<UserDto>> findAll(@RequestParam(value = "status") UserQueueLevel userQueueLevel, Pageable pageable) {
        Page<UserDto> userDtos = userService.findAllByStatus(userQueueLevel, pageable);
        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findBuId(@PathVariable(name = "id") Integer userId) {
        UserDto userDtos = userService.findById(userId);
        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

}
