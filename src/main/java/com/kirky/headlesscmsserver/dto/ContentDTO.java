package com.kirky.headlesscmsserver.dto;

import com.kirky.headlesscmsserver.model.Block;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class ContentDTO implements Serializable {
    private Integer id;
    private String title;
    private String name;
    private String author;
    private String description;
    private List<Block> blocks;
}
