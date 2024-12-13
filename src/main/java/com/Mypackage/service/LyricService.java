
package com.yourpackage.service;

import com.yourpackage.model.Lyric;
import com.yourpackage.repository.LyricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LyricService {
    @Autowired
    private LyricRepository lyricRepository;

    public List<Lyric> getAllLyrics() {
        return lyricRepository.findAll();
    }

    public Lyric getLyricById(Long id) {
        return lyricRepository.findById(id).orElse(null);
    }

    public Lyric addLyric(Lyric lyric) {
        lyric.setCreatedAt(LocalDateTime.now());
        lyric.setUpdatedAt(LocalDateTime.now());
        return lyricRepository.save(lyric);
    }

    public Lyric updateLyric(Long id, Lyric lyricDetails) {
        Lyric lyric = getLyricById(id);
        if (lyric != null) {
            lyric.setTitle(lyricDetails.getTitle());
            lyric.setArtist(lyricDetails.getArtist());
            lyric.setAlbum(lyricDetails.getAlbum());
            lyric.setSongwriter(lyricDetails.getSongwriter());
            lyric.setLyrics(lyricDetails.getLyrics());
            lyric.setUpdatedAt(LocalDateTime.now());
            return lyricRepository.save(lyric);
        }
        return null;
    }

    public void deleteLyric(Long id) {
        lyricRepository.deleteById(id);
    }
}
