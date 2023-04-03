package com.example.videocollection.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class VideoExceptionHandler {

    @ExceptionHandler(VideoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handleVideoNotFoundException(VideoNotFoundException ex) {
        return ErrorMessage.builder()
                           .message(ex.getMessage())
                           .build();
    }

    @ExceptionHandler(VideoCreationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleVideoCreationException(VideoCreationException ex) {
        return ErrorMessage.builder()
                           .message(ex.getMessage())
                           .build();
    }

}
