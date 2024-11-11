package com.example.demo.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {

    @Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
    
    private String nombre;
    private String rut;

    @OneToMany(fetch = FetchType.EAGER , mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<UserData> datos;

}