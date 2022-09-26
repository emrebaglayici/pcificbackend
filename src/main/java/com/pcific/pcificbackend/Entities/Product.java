package com.pcific.pcificbackend.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Builder @Data @AllArgsConstructor @NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Double price;
    private String shortDescription;
    private String longDescription;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "product_images",
    joinColumns = {
            @JoinColumn(name = "product_id")
    },
            inverseJoinColumns = {
            @JoinColumn(name ="image_id" )
            }
    )
    private Set<Image> productImages;

    @ManyToMany(mappedBy = "products")
    private List<Tags> tags;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private Set<Size> size;
}
