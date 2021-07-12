package com.springTest.Demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class AlbumController {
    @Autowired
    AlbumRepository albumRepository;


    //  @ResponseBody
    @GetMapping("/albums")
    public String album(Model model) {
//        Album album1 = new Album("25", "Adele", "11", "48 min 25 sec", "https://media.kidozi.com/unsafe/600x600/img.kidozi.com/art/3/600/600/0a0909/6422/1476073135-Adele25.png.jpg");
//        Album album2 = new Album("Deluxe", "Ed Sheeran", "16", "59 min 33 sec", "https://www.londondrugs.com/on/demandware.static/-/Sites-londondrugs-master/default/dw9454fa74/products/L7502537/large/L7502537.JPG");
//        Album album3 = new Album("24k Magic", "Bruno Mars", "9", "33 min 32 sec", "https://i1.sndcdn.com/artworks-000509638275-sam717-t500x500.jpg");
//        Object[] albums = new Object[]{album1, album2, album3};
        List<Album> albums = albumRepository.findAll();
        model.addAttribute("albums", albums);
        return "albums";
    }

    @PostMapping("/albums")
    public RedirectView addAlbum(String title, String artist, String songCount, String length, String imageUrl) {
        Album album1 = new Album(title, artist, songCount, length, imageUrl);
        albumRepository.save(album1);
        return new RedirectView("/albums");
    }
}
