package com.example.zoo.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.Size;
@Entity
@Data
@Table(name="Animals")
@Accessors(chain = true)
public class Animal {
    @Id
    @Column(nullable = false)
    private long id;
    @Column(nullable = false)
    @Size(min = 2)
    private String kind;
    @Column(nullable = false)
    @Size(min = 2)
    private String name;
    @ManyToMany
    @JoinTable(
        name = "animal_guardian",
        joinColumns = @JoinColumn(name = "animal_id"),
        inverseJoinColumns = @JoinColumn(name = "guardian_id")
    )
    List<Guardian>guardians;
    @ManyToOne 
    @JoinColumn(name = "enclosure_id")
    @Column(nullable = false)
    private Enclosure enclosure;
}
