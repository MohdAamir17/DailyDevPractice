package com.LearningLogs.Service;


import com.LearningLogs.Domain.Employee;

public interface EmployeeService {
    Employee addEmployee(Employee employee);

    void switchToDataSource1();

    void switchToDataSource2();

     /*  @Bean (name = "dataSource1")
    public DataSource getDataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/learninglog");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("root");
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        return dataSourceBuilder.build();
    }
    */
}
