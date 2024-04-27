package com.kirky.headlesscmsserver.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class BlockDTO implements Serializable {
    private Integer id;
    private String heading;
    private String subHeading;
    private String description;
    private String body;
    private String imageUrl;
}
