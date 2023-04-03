package com.example.videocollection.controller;

import com.example.videocollection.model.entity.Video;
import com.example.videocollection.service.VideoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/videos")
public class VideoController {

    private VideoService videoService;

    @GetMapping("/{id}")
    public Mono<Video> getOneVideo(@PathVariable String id) {
        return videoService.getOneVideo(id);
    }

    @GetMapping
    public Flux<Video> getAllVideos() {
       return videoService.getAllVideos();
    }

    @PostMapping
    public Mono<Video> createVideo(@RequestBody Video video) {
        return videoService.createVideo(video);
    }

}
