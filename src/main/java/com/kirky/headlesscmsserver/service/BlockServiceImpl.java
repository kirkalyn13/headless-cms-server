package com.kirky.headlesscmsserver.service;

import com.kirky.headlesscmsserver.dto.BlockDTO;
import com.kirky.headlesscmsserver.model.Block;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlockServiceImpl implements BlockService {
    @Autowired
    ModelMapper modelMapper;

    private BlockDTO convertToDTO(Block entity) {
        return modelMapper.map(entity, BlockDTO.class);
    }

    private Block convertToEntity(BlockDTO dto) {
        return modelMapper.map(dto, Block .class);
    }
}
