package com.designPatterns.bridge;

public class HDVideoProcessor implements VideoProcessor {

    @Override
    public String processVideo() {
        return "HD video quality";
    }
}
