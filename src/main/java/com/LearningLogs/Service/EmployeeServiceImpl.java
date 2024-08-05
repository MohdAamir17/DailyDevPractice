package com.LearningLogs.Service;

import com.LearningLogs.Configuration.DataSourceContextHolder;
import com.LearningLogs.Domain.Employee;
import com.LearningLogs.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private static final Logger logger = Logger.getLogger(EmployeeServiceImpl.class.getName());

    @Autowired
    private EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public void switchToDataSource1() {
        DataSourceContextHolder.setDataSourceKey("dataSource1");
    }

    public void switchToDataSource2() {
        DataSourceContextHolder.setDataSourceKey("dataSource2");
    }

    @Override
    public Employee addEmployee(Employee employee) {
        logger.info("Received request to add employee: " + employee);
        try {
            Employee savedEmployee = employeeRepo.save(employee);
            logger.info("Employee successfully added with ID: " + savedEmployee.getId());
            return savedEmployee;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error saving employee: " + e.getMessage(), e);
            throw e; // Rethrow the exception to be handled by the caller
        }
    }
}
