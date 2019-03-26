package com.example.isaquecoelho.podcastproject.model;

import java.util.List;

public class Podcast {

    private String podcastTitle;
    private String podcastDate;
    private String podcastDuration;
    private String podcastAutor;
    private String podcastTheme;
    private int podcastBanner;
    private List<Participant> podcastParticipantList;
    private List<Podcast> podcastPlaylist;

    public Podcast(String podcastTitle, String podcastDate, String podcastDuration, String podcastAutor, String podcastTheme, int podcastBanner, List<Participant> podcastParticipantList, List<Podcast> podcastPlaylist) {
        this.podcastTitle = podcastTitle;
        this.podcastDate = podcastDate;
        this.podcastDuration = podcastDuration;
        this.podcastAutor = podcastAutor;
        this.podcastTheme = podcastTheme;
        this.podcastBanner = podcastBanner;
        this.podcastParticipantList = podcastParticipantList;
        this.podcastPlaylist = podcastPlaylist;
    }

    public String getPodcastTitle() {
        return podcastTitle;
    }

    public void setPodcastTitle(String podcastTitle) {
        this.podcastTitle = podcastTitle;
    }

    public String getPodcastDate() {
        return podcastDate;
    }

    public void setPodcastDate(String podcastDate) {
        this.podcastDate = podcastDate;
    }

    public String getPodcastDuration() {
        return podcastDuration;
    }

    public void setPodcastDuration(String podcastDuration) {
        this.podcastDuration = podcastDuration;
    }

    public String getPodcastAutor() {
        return podcastAutor;
    }

    public void setPodcastAutor(String podcastAutor) {
        this.podcastAutor = podcastAutor;
    }

    public String getPodcastTheme() {
        return podcastTheme;
    }

    public void setPodcastTheme(String podcastTheme) {
        this.podcastTheme = podcastTheme;
    }

    public int getPodcastBanner() {
        return podcastBanner;
    }

    public void setPodcastBanner(int podcastBanner) {
        this.podcastBanner = podcastBanner;
    }

    public List<Participant> getPodcastParticipantList() {
        return podcastParticipantList;
    }

    public void setPodcastParticipantList(List<Participant> podcastParticipantList) {
        this.podcastParticipantList = podcastParticipantList;
    }

    public List<Podcast> getPodcastPlaylist() {
        return podcastPlaylist;
    }

    public void setPodcastPlaylist(List<Podcast> podcastPlaylist) {
        this.podcastPlaylist = podcastPlaylist;
    }
}
