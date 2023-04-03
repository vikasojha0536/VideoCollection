package com.example.videocollection.repository;

import com.example.videocollection.model.entity.Video;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends ReactiveMongoRepository<Video, String> {

}