package com.pcific.pcificbackend.Entities;

import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
@Builder @AllArgsConstructor @NoArgsConstructor
@Table(name = "categories")
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
