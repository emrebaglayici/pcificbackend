package com.pcific.pcificbackend.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Getter
@Setter
@Entity
public class Tags {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(joinColumns = @JoinColumn(name = "tags_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "product_id",referencedColumnName = "id"))
//    @JoinTable(
//            name = "products_tags",
//            joinColumns = @JoinColumn(name = "tags_id"),
//            inverseJoinColumns = @JoinColumn(name = "product_id")
//    )
    private List<Product> products;

}
