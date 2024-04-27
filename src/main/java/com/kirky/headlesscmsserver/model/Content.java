package com.kirky.headlesscmsserver.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "content")
@Data
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "author")
    private String author;

    @JsonBackReference
    @OneToMany( fetch = FetchType.LAZY, mappedBy = "id", cascade = CascadeType.ALL)
    private List<Block> blocks;
}
