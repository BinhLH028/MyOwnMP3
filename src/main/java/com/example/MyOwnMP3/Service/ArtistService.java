package com.example.MyOwnMP3.Service;

import com.example.MyOwnMP3.Model.Artist;
import com.example.MyOwnMP3.Model.Song;
import com.example.MyOwnMP3.Repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class ArtistService {
    @Autowired
    ArtistRepository artistRepository;

    @Autowired
    MessageSource messageSource;

    public String InsertNewArtist(Artist data) {
        artistRepository.save(data);
        return messageSource.getMessage("02", new String[]{data.getArtistName()}, Locale.getDefault());
    }

    public List<Artist> GetArtistByName(String n) {
        return artistRepository.findByArtistNameContainingIgnoreCase(n);
    }
}
