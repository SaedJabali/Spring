package com.springTest.Demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collections;
import java.util.List;

@Controller
public class AlbumController {
    @Autowired
    AlbumRepository albumRepository;
    SongRepo songRepo;

    //  @ResponseBody
    @GetMapping("/")
    public String albumTest() {
        Album album1 = new Album("25", "Adele", "11", "48 min 25 sec", "https://media.kidozi.com/unsafe/600x600/img.kidozi.com/art/3/600/600/0a0909/6422/1476073135-Adele25.png.jpg");
        Album album2 = new Album("Deluxe", "Ed Sheeran", "16", "59 min 33 sec", "https://www.londondrugs.com/on/demandware.static/-/Sites-londondrugs-master/default/dw9454fa74/products/L7502537/large/L7502537.JPG");
        Album album3 = new Album("24k Magic", "Bruno Mars", "9", "33 min 32 sec", "https://i1.sndcdn.com/artworks-000509638275-sam717-t500x500.jpg");
        albumRepository.saveAndFlush(album1);
        albumRepository.saveAndFlush(album2);
        albumRepository.saveAndFlush(album3);
//        albumRepository.deleteAll();
        return "landing";
    }

    @GetMapping("/albums")
    public String album(Model model) {
        List<Album> albums = albumRepository.findAll();
        model.addAttribute("albums", albums);
        return "albums";
    }

    @PostMapping("/albums")
    ResponseEntity<Album> newAlbum(String title, String artist, String songCount, String length, String imageUrl) {
        Album savedAlbum = albumRepository.saveAndFlush(new Album(title, artist, songCount, length, imageUrl));
        return new ResponseEntity<>(savedAlbum, HttpStatus.CREATED);
    }

    @GetMapping("/albums/{id}")
    public ResponseEntity<Album> getAlbumDetail(@PathVariable long id) {
        Album albumById = albumRepository.findById(id).orElseThrow();
        return new ResponseEntity<>(albumById, HttpStatus.OK);
    }

    @GetMapping("/songs/{id}")
    public String songs(@PathVariable long id, Model model) {
        Album albumById = albumRepository.findById(id).orElseThrow();
        model.addAttribute("album", albumById);
        return "songs";
    }

    @PostMapping("/addSong")
    public RedirectView addNewSong(String title, String length, String trackNumber, String id) {
        System.out.println(title + "" + length + "" + trackNumber + "" + id);
        Long albumId = Long.parseLong(id);
        List<Album> songAlbum = albumRepository.findAllById(Collections.singleton(albumId));
        Song song = new Song(title, length, trackNumber, songAlbum.get(0));
        songRepo.save(song);
        return new RedirectView("/songs/" + albumId);
    }
}