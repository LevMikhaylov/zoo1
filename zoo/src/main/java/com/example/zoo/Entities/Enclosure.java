package com.example.zoo.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;
@Entity
@Table(name = "Enclosures")
@Accessors(chain = true)
@Data
public class Enclosure {
    @Id
    @Column
    private long id;
    @Column(nullable = false)
    @OneToMany(mappedBy = "enclosure")  
    private List<Animal> animals;
}
