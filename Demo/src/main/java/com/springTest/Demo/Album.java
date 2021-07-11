package com.springTest.Demo;

public class Album {

    String title;
    String artist;
    String songCount;
    String length;
    String imageUrl;

    public Album(String title, String artist, String songCount, String length, String imageUrl) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getSongCount() {
        return songCount;
    }

    public String getLength() {
        return length;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
