package com.yourpackage.controller;

import com.yourpackage.model.Lyric;
import com.yourpackage.service.LyricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lyrics")
public class LyricController {
    @Autowired
    private LyricService lyricService;

    @GetMapping
    public List<Lyric> getAllLyrics() {
        return lyricService.getAllLyrics();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lyric> getLyricById(@PathVariable Long id) {
        Lyric lyric = lyricService.getLyricById(id);
        return lyric != null ? ResponseEntity.ok(lyric) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Lyric addLyric(@RequestBody Lyric lyric) {
        return lyricService.addLyric(lyric);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lyric> updateLyric(@PathVariable Long id, @RequestBody Lyric lyric) {
        Lyric updatedLyric = lyricService.updateLyric(id, lyric);
        return updatedLyric != null ? ResponseEntity.ok(updatedLyric) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLyric(@PathVariable Long id) {
        lyricService.deleteLyric(id);
        return ResponseEntity.noContent().build();
    }
}
