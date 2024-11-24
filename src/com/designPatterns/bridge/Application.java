package com.designPatterns.bridge;

public class Application {

    public static void main(String[] args) {
        VideoPlayer videoPlayer = new NetflixVideoPlayer(new UHDVideoProcessor());
        videoPlayer.playVideo();

        videoPlayer = new YoutubeVideoPlayer(new HDVideoProcessor());
        videoPlayer.playVideo();
    }
}
