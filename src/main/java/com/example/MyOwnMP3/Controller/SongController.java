package com.example.MyOwnMP3.Controller;

import com.example.MyOwnMP3.Service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/API/Song")
public class SongController {

    @Autowired
    SongService songService;
    @GetMapping(value = "/getAllSong")
    public ResponseEntity<?> GetAllSong() {
        System.out.println(songService.GetAllSong());
        return new ResponseEntity<>(songService.GetAllSong(), HttpStatus.OK);
    }
}
