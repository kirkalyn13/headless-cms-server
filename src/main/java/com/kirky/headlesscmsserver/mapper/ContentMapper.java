package com.kirky.headlesscmsserver.mapper;

import com.kirky.headlesscmsserver.dto.ContentDTO;
import com.kirky.headlesscmsserver.model.Content;
import org.modelmapper.ModelMapper;

public class ContentMapper {
    ModelMapper modelMapper;
    private ContentDTO convertToDTO(Content entity) {
        return modelMapper.map(entity, ContentDTO.class);
    }

    private Content convertToEntity(ContentDTO dto) {
        return modelMapper.map(dto, Content.class);
    }
}
