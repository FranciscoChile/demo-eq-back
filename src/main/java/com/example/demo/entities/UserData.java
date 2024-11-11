package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "data")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserData {

    @Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

    private String campo1;
    private String campo2;


    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    @JsonBackReference
    private User user;

}
