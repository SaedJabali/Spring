package com.springTest.Demo;

import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id;
    String title;
    String length;
    String trackNumber;
    @ManyToOne
    @JoinColumn(name = "album_id")
    Album album;

    public Song() {
    }



    public Song(String title, String length, String trackNumber, Album songAlbum) {
        this.title = title;
        this.length = length;
        this.trackNumber = trackNumber;
        this.album = album;
    }

    public String getTitle() {
        return title;
    }

    public String getLength() {
        return length;
    }

    public String getTrackNumber() {
        return trackNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public void setTrackNumber(String trackNumber) {
        this.trackNumber = trackNumber;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
