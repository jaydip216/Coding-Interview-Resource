package com.designPatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class NewsAgency {

    private List<Channel> channels;

    public NewsAgency() {
        this.channels = new ArrayList<>();
    }

    public void addChannel(Channel channel) {
        this.channels.add(channel);
    }

    public void removeChannel(Channel channel) {
        this.channels.remove(channel);
    }

    public void update(String news) {
        for (Channel channel : this.channels) {
            channel.update(news);
        }
    }
}
