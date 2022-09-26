package com.pcific.pcificbackend.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder @NoArgsConstructor @AllArgsConstructor
public class Size {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
