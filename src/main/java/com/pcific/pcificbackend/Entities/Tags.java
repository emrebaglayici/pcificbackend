package com.pcific.pcificbackend.Entities;

import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
@Builder @AllArgsConstructor @NoArgsConstructor
@Table(name = "tags")
public class Tags {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
}
