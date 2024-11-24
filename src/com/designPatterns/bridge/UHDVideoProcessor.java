package com.designPatterns.bridge;

public class UHDVideoProcessor implements VideoProcessor {

    @Override
    public String processVideo() {
        return "UHD video quality";
    }
}
