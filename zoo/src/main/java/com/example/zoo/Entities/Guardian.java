package com.example.zoo.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;

@SuppressWarnings("unused")
@Entity
@Data
@Table(name = "Guardians")
@Accessors(chain = true)
public class Guardian {
    @Id
    @Column(nullable = false)
    private long id;
    @Column(nullable=false)
    @Size(min = 2)
    private String name;
    @Column(nullable = false)
    @Size(min = 2)
    private String surname;
    @Column(nullable=false)
    @Email
    private String email;
    @Column(nullable = false)
    @Pattern(regexp="\\+7\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$", message="Invalid phone number format")//Задаём формат номера телефона в России
    private String phoneNumber;
}
