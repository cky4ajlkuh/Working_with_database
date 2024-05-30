package com.example.postgresql.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table(name = "Person")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    private long id;
    private String name;
}
