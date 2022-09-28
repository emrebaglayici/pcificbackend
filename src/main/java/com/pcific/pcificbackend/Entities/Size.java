package com.pcific.pcificbackend.Entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder @NoArgsConstructor @AllArgsConstructor
public class Size {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer quantity;
}
