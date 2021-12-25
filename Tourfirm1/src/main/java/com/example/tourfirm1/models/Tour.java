package com.example.tourfirm1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "FreeTours")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;

    private String country;

    private String description;

    private int price;
}
