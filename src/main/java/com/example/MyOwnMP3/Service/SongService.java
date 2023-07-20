package com.example.MyOwnMP3.Service;

import com.example.MyOwnMP3.Model.Song;
import com.example.MyOwnMP3.Repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class SongService {

    @Autowired
    SongRepository songRepository;

    public Page<Song> GetAllSong(){
        Page<Song> tmp = songRepository.findAll(PageRequest.of(0,1));
        return tmp;
    }
}
