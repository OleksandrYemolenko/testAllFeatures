package com.yermolenko.controllers;

import javax.validation.Valid;

import com.yermolenko.controllers.utils.MappingValues;
import com.yermolenko.controllers.utils.Path;
import com.yermolenko.controllers.utils.ProjMediaType;
import com.yermolenko.dto.UserDTO;
import com.yermolenko.mappers.UserMapper;
import lombok.SneakyThrows;
import com.yermolenko.models.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yermolenko.services.UserService;

@RestController
@RequestMapping(path = Path.USER)
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @SneakyThrows
    @PostMapping(consumes = ProjMediaType.USER,
            produces = ProjMediaType.USER)
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO user) {

        final IUser createdUser = userService.create(user);
        final UserDTO createdUserDTO = userMapper.toUserDTO(createdUser);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdUserDTO);
    }

    @SneakyThrows
    @PutMapping(value = MappingValues.GUID,
             consumes = ProjMediaType.USER,
             produces = ProjMediaType.USER)
    public ResponseEntity<UserDTO> updateUser(@PathVariable("guid") String guid, @RequestBody @Valid UserDTO user) {
        final IUser updatedUser = userService.update(user, guid);
        final UserDTO updatedUserDTO = userMapper.toUserDTO(updatedUser);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updatedUserDTO);
    }

    @GetMapping(value = MappingValues.GUID, produces = ProjMediaType.USER)
    public ResponseEntity<UserDTO> getUser(@PathVariable String guid) {
        final IUser currentUser = userService.getUserByGuid(guid);
        final UserDTO currentUserDTO = userMapper.toUserDTO(currentUser);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(currentUserDTO);
    }

    @DeleteMapping(value = MappingValues.GUID)
    public ResponseEntity deleteUser(@PathVariable String guid) {
        userService.delete(guid);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    @GetMapping(value = "/hello")
    public String index() {
        return "Hello";
    }
}
