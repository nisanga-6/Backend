package com.example.emsBackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class Employee {

    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "first_ame")
    String firstName;
    @Column(name="last_name")
    String lastName;
    @Column(name="email", nullable = false,unique = true)
    String email;
}
