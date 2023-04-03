package com.example.videocollection.service;

import com.example.videocollection.model.entity.Video;
import com.example.videocollection.repository.VideoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class VideoService {

    private VideoRepository videoRepository;

    public Mono<Video> getOneVideo(String id) {
        return videoRepository.findById(id);
    }

    public Flux<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    public Mono<Video> createVideo(Video video) {
        return videoRepository.save(video)
                .doOnSuccess(s -> log.info("Saving video {}", video))
                .doOnNext(v -> log.info("Video saved with details {}", v));
    }
}
