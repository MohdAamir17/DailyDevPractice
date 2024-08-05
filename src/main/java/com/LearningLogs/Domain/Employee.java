package com.LearningLogs.Domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "employees")
@Getter
@Setter
public class Employee extends BaseEntity {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "hire_date", nullable = false)
    private LocalDateTime hireDate;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "department")
    private String department;

    @Column(name = "position")
    private String position;

    @ManyToOne(cascade = CascadeType.ALL) // Use CascadeType.ALL to automatically save the address when saving the employee
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;
}
