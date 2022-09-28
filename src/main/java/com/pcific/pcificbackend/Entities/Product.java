package com.pcific.pcificbackend.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Double price;
    private String shortDescription;
    private String longDescription;

//    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    @JoinTable(name = "product_images",
//    joinColumns = {
//            @JoinColumn(name = "product_id")
//    },
//            inverseJoinColumns = {
//            @JoinColumn(name ="image_id" )
//            }
//    )
//    private Set<Image> productImages;

//
//    @OneToMany(mappedBy = "product")
//    private Set<Size> size;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "product_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "size_id",referencedColumnName = "id")
    )
    private List<Size> sizes;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id")
            , inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    private List<Category> category;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id")
            , inverseJoinColumns = @JoinColumn(name = "tags_id", referencedColumnName = "id")
    )
    private List<Tags> tags;
}
