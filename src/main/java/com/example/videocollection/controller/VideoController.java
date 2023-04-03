package com.example.videocollection.controller;

import com.example.videocollection.model.entity.Video;
import com.example.videocollection.service.VideoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/videos")
public class VideoController {

    private VideoService videoService;

    @GetMapping("/{id}")
    public Optional<Video> getOneVideo(@PathVariable String id) {
        return videoService.getOneVideo(id);
    }

    @GetMapping
    public Iterable<Video> getAllVideos() {
       return videoService.getAllVideos();
    }

    @PostMapping
    public Video createVideo(Video video) {
        return videoService.createVideo(video);
    }

}
