package com.springTest.Demo;

import javax.persistence.*;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.ManyToOne;

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
    Album songAlbum;

    public Song() {
    }

    public Song(String title, String length, String trackNumber) {
        this.title = title;
        this.length = length;
        this.trackNumber = trackNumber;
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

    public Album getSongAlbum() {
        return songAlbum;
    }
}
