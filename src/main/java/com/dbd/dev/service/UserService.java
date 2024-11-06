package com.dbd.dev.service;

import com.dbd.dev.dto.UserDTO;
import com.dbd.dev.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    List<User> getAllUserDetails();
}
