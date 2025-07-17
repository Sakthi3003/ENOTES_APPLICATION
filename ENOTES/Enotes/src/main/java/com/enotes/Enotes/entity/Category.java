package com.enotes.Enotes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "category")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseModel{
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;

}
