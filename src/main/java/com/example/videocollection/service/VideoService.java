package com.example.videocollection.service;

import com.example.videocollection.model.dto.VideoRequest;
import com.example.videocollection.model.dto.VideoResponse;
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

    public Mono<VideoResponse> getOneVideo(String id) {
        return videoRepository.findById(id)
                .map(VideoResponse::fromEntity);
    }

    public Flux<VideoResponse> getAllVideos() {
        return videoRepository.findAll()
                .map(VideoResponse::fromEntity);
    }

    public Mono<VideoResponse> createVideo(VideoRequest videoRequest) {
        return videoRepository.save(videoRequest.toEntity())
                .map(VideoResponse::fromEntity);

    }
}
