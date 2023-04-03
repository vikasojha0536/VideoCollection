package com.example.videocollection.service;

import com.example.videocollection.model.entity.Video;
import com.example.videocollection.repository.VideoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class VideoService {

    private VideoRepository videoRepository;

    public Optional<Video> getOneVideo(String id) {
        return videoRepository.findById(id);
    }

    public Iterable<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    public Video createVideo(Video video) {
        return videoRepository.save(video);
    }
}
