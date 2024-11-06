package com.dbd.dev.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderDetails;
    // Many-to-One relationship with User
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    @JsonBackReference
    private User user;

}
