package com.pcific.pcificbackend.Entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Data @Getter @Setter
@Builder @NoArgsConstructor @AllArgsConstructor
public class Size {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
