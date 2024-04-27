package com.kirky.headlesscmsserver.service;

import com.kirky.headlesscmsserver.dto.ContentDTO;

import java.util.List;

public interface ContentService {
    ContentDTO getContentByName(String name);
    ContentDTO addContent(ContentDTO contentDTO) throws Exception;
    void deleteContentById(Integer id);
}
