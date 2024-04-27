package com.kirky.headlesscmsserver.mapper;

import com.kirky.headlesscmsserver.dto.BlockDTO;
import com.kirky.headlesscmsserver.model.Block;
import org.modelmapper.ModelMapper;

public class BlockMapper {
    ModelMapper modelMapper;
    private BlockDTO convertToDTO(Block entity) {
        return modelMapper.map(entity, BlockDTO.class);
    }

    private Block  convertToEntity(BlockDTO dto) {
        return modelMapper.map(dto, Block .class);
    }
}
