package com.kirky.headlesscmsserver.repository;

import com.kirky.headlesscmsserver.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends JpaRepository<Content, Integer> {
    Content findContentByName(String name);
}
