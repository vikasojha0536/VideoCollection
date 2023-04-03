package com.example.videocollection.controller;

import com.example.videocollection.exception.VideoNotFoundException;
import com.example.videocollection.model.dto.VideoRequest;
import com.example.videocollection.model.dto.VideoResponse;
import com.example.videocollection.service.VideoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@RestController
@AllArgsConstructor
@RequestMapping("/videos")
public class VideoController {

    private VideoService videoService;

    @GetMapping("/{id}")
    public Mono<VideoResponse> getOneVideo(@PathVariable String id) {
        return videoService.getOneVideo(id)
                           .switchIfEmpty(Mono.error(
                                   new VideoNotFoundException("Video not found: " + id)));
    }

    @GetMapping
    public Flux<VideoResponse> getAllVideos(@RequestParam(required = false, defaultValue = "0") BigDecimal priceGraterThan) {
        return videoService.getAllVideos(priceGraterThan);
    }

    @PostMapping
    public Mono<VideoResponse> createVideo(@RequestBody VideoRequest videoRequest) {
        return videoService.createVideo(videoRequest);
    }

}
