package com.designPatterns.bridge;

public class YoutubeVideoPlayer extends VideoPlayer {

    public YoutubeVideoPlayer(VideoProcessor videoProcessor) {
        super(videoProcessor);
    }

    @Override
    public void playVideo() {
        System.out.println("Playing video from Youtube with " + videoProcessor.processVideo());
    }
}
