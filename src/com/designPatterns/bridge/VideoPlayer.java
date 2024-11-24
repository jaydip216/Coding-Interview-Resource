package com.designPatterns.bridge;

public abstract class VideoPlayer {

    protected VideoProcessor videoProcessor;

    public VideoPlayer(VideoProcessor videoProcessor) {
        this.videoProcessor = videoProcessor;
    }

    public abstract void playVideo();

}
