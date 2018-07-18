package com.aibank.jdk8.data;

public class Track {

    private String name;

    private long times;

    public Track(String name, long times) {
        this.name = name;
        this.times = times;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTimes() {
        return times;
    }

    public void setTimes(long times) {
        this.times = times;
    }
}
