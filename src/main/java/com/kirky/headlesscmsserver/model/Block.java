package com.kirky.headlesscmsserver.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "blocks")
@Data
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "heading")
    private String heading;

    @Column(name = "subHeading")
    private String subHeading;

    @Column(name = "description")
    private String description;

    @Column(name = "body", length = 5000)
    private String body;

    @Column(name = "imageUrl")
    private String imageUrl;
}
