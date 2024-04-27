package com.kirky.headlesscmsserver.service;

import com.kirky.headlesscmsserver.dto.ContentDTO;
import com.kirky.headlesscmsserver.model.Content;
import com.kirky.headlesscmsserver.repository.ContentRepository;
import org.hibernate.PropertyNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    ContentRepository contentRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ContentDTO getContentByName(String name) {
        Content content = contentRepository.findContentByName(name);
        if (content == null) throw new PropertyNotFoundException("Content not found: " + name);

        return convertToDTO(content);
    }

    @Override
    @Transactional
    public ContentDTO addContent(ContentDTO contentDTO) throws Exception {
        String contentName = convertContentTitleToName(contentDTO.getTitle());
        Content content = contentRepository.findContentByName(contentName);

        if (content != null) throw new Exception("Content already exists: " + contentDTO.getName());
        contentDTO.setName(contentName);
        contentRepository.save(convertToEntity(contentDTO));
        contentDTO.setName(contentName);

        return contentDTO;
    }

    @Override
    @Transactional
    public void deleteContentById(Integer id) {
        Content content = contentRepository.findContentById(id);
        if (content == null) throw new PropertyNotFoundException("Content not found: " + id);
        contentRepository.deleteContentById(id);
    }

    @Override
    @Transactional
    public ContentDTO editContent(Integer id, ContentDTO contentDTO) {
        Content content = contentRepository.findContentById(id);

        if (content == null) throw new PropertyNotFoundException("Content not found: " + id);
        if (contentDTO.getTitle() != null) {
            content.setTitle(contentDTO.getTitle());
            String contentName = convertContentTitleToName(contentDTO.getTitle());
            content.setName(contentName);
            contentDTO.setName(contentName);
        }
        if (contentDTO.getAuthor() != null) {
            content.setAuthor(contentDTO.getAuthor());
        }
        if (contentDTO.getDescription() != null) {
            content.setDescription(contentDTO.getDescription());
        }
        if (!contentDTO.getBlocks().isEmpty()) {
            content.setBlocks(contentDTO.getBlocks());
        }

        contentRepository.save(content);
        contentDTO.setId(content.getId());

        return contentDTO;
    }

    private static String convertContentTitleToName(String title) {
        return title.toLowerCase().replaceAll("\\s+", "-");
    }

    private ContentDTO convertToDTO(Content entity) {
        return modelMapper.map(entity, ContentDTO.class);
    }

    private Content convertToEntity(ContentDTO dto) {
        return modelMapper.map(dto, Content.class);
    }
}
