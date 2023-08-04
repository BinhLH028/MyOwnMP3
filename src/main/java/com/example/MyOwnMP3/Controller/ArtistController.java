package com.example.MyOwnMP3.Controller;

import com.example.MyOwnMP3.Model.Artist;
import com.example.MyOwnMP3.Service.ArtistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/API/artist")
@Slf4j
public class ArtistController {

    @Autowired
    ArtistService artistService;

    @PostMapping
    public ResponseEntity<?> AddArtist(@RequestBody Artist data){
        try{
            return new ResponseEntity<>(artistService.InsertNewArtist(data), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> GetArtistByName(@RequestParam String n){
        try{
            return new ResponseEntity<>(artistService.GetArtistByName(n), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
