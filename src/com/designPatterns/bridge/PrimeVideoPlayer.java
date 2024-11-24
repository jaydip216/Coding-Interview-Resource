package com.designPatterns.bridge;

public class PrimeVideoPlayer extends VideoPlayer {

    public PrimeVideoPlayer(VideoProcessor videoProcessor) {
        super(videoProcessor);
    }

    @Override
    public void playVideo() {
        System.out.println("Playing video from Prime with " + videoProcessor.processVideo());
    }
}
