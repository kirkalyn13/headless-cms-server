package com.kirky.headlesscmsserver.controller;

import com.kirky.headlesscmsserver.dto.ContentDTO;
import com.kirky.headlesscmsserver.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/content")
public class ContentController {
    @Autowired
    ContentService contentService;

    @GetMapping("/{name}")
    public ResponseEntity<ContentDTO> getContent(@PathVariable("name") String name) {
        ContentDTO result = contentService.getContentByName(name);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ContentDTO> addContent(@RequestBody ContentDTO contentDTO) throws Exception {
        ContentDTO result = contentService.addContent(contentDTO);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id:.+}")
    public ResponseEntity<ContentDTO> editContent(
            @PathVariable("id") Integer id,
            @RequestBody ContentDTO contentDTO) {
        ContentDTO result = contentService.editContent(id, contentDTO);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id:.+}")
    public ResponseEntity<String> deleteContent(@PathVariable("id") Integer id) {
        contentService.deleteContentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
