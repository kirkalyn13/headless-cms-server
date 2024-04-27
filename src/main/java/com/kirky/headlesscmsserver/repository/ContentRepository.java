package com.kirky.headlesscmsserver.repository;

import com.kirky.headlesscmsserver.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository extends JpaRepository<Content, Integer> {
    Content findContentByName(String name);
    Content findContentById(Integer id);
    void deleteContentById(Integer id);
}
