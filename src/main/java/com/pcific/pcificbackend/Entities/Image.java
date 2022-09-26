package com.pcific.pcificbackend.Entities;

import lombok.*;

import javax.persistence.*;

@Entity @Table(name = "image") @Getter @Setter
public class Image {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String type;
    @Column(length = 5000000)
    private byte[] picByte;

    public Image() {
    }

    public Image(String name, String type, byte[] picByte) {
        this.name = name;
        this.type = type;
        this.picByte = picByte;
    }
}
