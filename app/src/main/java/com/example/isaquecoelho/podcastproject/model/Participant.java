package com.example.isaquecoelho.podcastproject.model;

public class Participant {

    private String name;
    private String socialMedia;

    public Participant(String name, String socialMedia) {
        this.name = name;
        this.socialMedia = socialMedia;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSocialMedia() {
        return socialMedia;
    }

    public void setSocialMedia(String socialMedia) {
        this.socialMedia = socialMedia;
    }
}
