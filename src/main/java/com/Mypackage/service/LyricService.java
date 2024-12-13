package com.yourpackage.repository;

import com.yourpackage.model.Lyric;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LyricRepository extends JpaRepository<Lyric, Long> {
    List<Lyric> findByTitleContaining(String title);
}
