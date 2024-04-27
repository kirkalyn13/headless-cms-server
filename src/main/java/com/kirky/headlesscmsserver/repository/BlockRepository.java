package com.kirky.headlesscmsserver.repository;

import com.kirky.headlesscmsserver.model.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockRepository extends JpaRepository<Block, Integer> {
}
