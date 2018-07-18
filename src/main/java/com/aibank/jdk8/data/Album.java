package com.aibank.jdk8.data;

import java.util.Date;
import java.util.List;

public class Album {

    public String name;

    public Date publishTime;

    public List<Track> tracks;

    public Artist musician;

    public Album(String name, Date publishTime) {
        this.name = name;
        this.publishTime = publishTime;
    }

    public Album(String name, Date publishTime, List<Track> tracks, Artist musician) {
        this.name = name;
        this.publishTime = publishTime;
        this.tracks = tracks;
        this.musician = musician;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public Artist getMusician() {
        return musician;
    }

    public void setMusician(Artist musician) {
        this.musician = musician;
    }
}
