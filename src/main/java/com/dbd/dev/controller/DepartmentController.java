package com.dbd.dev.controller;

import com.dbd.dev.entity.Department;
import com.dbd.dev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        Department newDepartment = userService.createDepartment(department);
        return ResponseEntity.ok(newDepartment);
    }

    @GetMapping
    public ResponseEntity<Object> getDepartment (@RequestBody Department department) {
        List<Department> listOfDepartment = userService.getDepartment(department);
        return ResponseEntity.ok(listOfDepartment);
    }

    @DeleteMapping("/delete/{id}/{appId}")
    public ResponseEntity<Object> deleteDepartment(
            @PathVariable("id") Long departmentId,
            @PathVariable(value = "appId",required = false) Long applicationId) {

        userService.deleteDepartment(departmentId, applicationId);
        return ResponseEntity.ok().body("Department deleted successfully");
    }
}
