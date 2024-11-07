package com.dbd.dev.service.impl;

import com.dbd.dev.dto.UserDTO;
import com.dbd.dev.entity.Department;
import com.dbd.dev.entity.User;
import com.dbd.dev.repository.DepartmentRepository;
import com.dbd.dev.repository.UserRepository;
import com.dbd.dev.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public  User createUser(User user) {
        // Set the User reference in each Order
        if (user.getOrders() != null) {
            user.getOrders().forEach(order -> order.setUser(user));
        }
        // Now save the user with the associated orders
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUserDetails() {
        List<User> allUserList = userRepository.findAll();
        return allUserList;
    }

    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartment(Department department) {
        List<Department> departmentListByName = departmentRepository.findByNameIgnoreCase(department.getName());
        return departmentListByName;
    }
}
