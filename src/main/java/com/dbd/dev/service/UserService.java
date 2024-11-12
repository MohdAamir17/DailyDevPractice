package com.dbd.dev.service;

import com.dbd.dev.dto.UserDTO;
import com.dbd.dev.entity.Department;
import com.dbd.dev.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    List<User> getAllUserDetails();

    Department createDepartment(Department department);

    List<Department> getDepartment(Department department);

    void deleteDepartment(Long departmentId, Long applicationId);
}
