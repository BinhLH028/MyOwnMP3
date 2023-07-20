package com.example.MyOwnMP3.Controller;

import com.example.MyOwnMP3.Service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/API/Song")
public class SongController {

    @Autowired
    private SongService songService;
    @GetMapping(value = "/getAllSong")
    public ResponseEntity<?> GetAllSong() {
        return new ResponseEntity<>(songService.GetAllSong(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> GetSongsByName(@RequestParam String n){
        try{
            return new ResponseEntity<>(songService.GetSongsByName(n), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
