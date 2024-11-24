package com.designPatterns.bridge;

public class NetflixVideoPlayer extends VideoPlayer {

    public NetflixVideoPlayer(VideoProcessor videoProcessor) {
        super(videoProcessor);
    }

    @Override
    public void playVideo() {
        System.out.println("Playing video on Netflix player with " + videoProcessor.processVideo());
    }

}
