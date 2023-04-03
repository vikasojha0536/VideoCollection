package com.example.VideoCollection.controller;

import com.example.VideoCollection.model.entity.Video;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/videos")
public class VideoController {

    @GetMapping("/{id}")
    public Mono<Video> getOneVideo(@PathVariable String id) {
        return Mono.just(Video.builder()
                              .name("Video- "+id)
                              .build());
    }

    @GetMapping
    public Flux<Video> getAllVideos() {
        return Flux.range(1,5)
                .map(count -> Video.builder()
                                   .name("Video- "+count)
                                   .build());
    }

}
