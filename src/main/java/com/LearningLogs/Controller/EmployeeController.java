package com.LearningLogs.Controller;

import com.LearningLogs.Configuration.DataSourceContextHolder;
import com.LearningLogs.Domain.Employee;
import com.LearningLogs.Service.EmployeeService;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/emp")
public class EmployeeController {

    private static final Logger logger = Logger.getLogger(EmployeeController.class.getName());

    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee, @RequestParam String dataSource) {
        try {
            if ("dataSource1".equals(dataSource)) {
                employeeService.switchToDataSource1();
            } else if ("dataSource2".equals(dataSource)) {
                employeeService.switchToDataSource2();
            }

            Employee savedEmployee = employeeService.addEmployee(employee);
            return ResponseEntity.status(201).body(savedEmployee);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error saving employee: " + e.getMessage());
        } /*finally {
            DataSourceContextHolder.clearDataSourceKey(); // Ensure context is cleared after operation
        }*/
    }
}
