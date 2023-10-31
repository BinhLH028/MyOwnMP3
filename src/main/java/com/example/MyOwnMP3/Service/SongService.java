package com.example.MyOwnMP3.Service;

import java.io.*;

import com.example.MyOwnMP3.Common.Const;
import com.example.MyOwnMP3.Model.Song;
import com.example.MyOwnMP3.Repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongService {

    @Autowired
    SongRepository songRepository;

    public Page<Song> GetAllSong(){
        Page<Song> tmp = songRepository.findAll(PageRequest.of(0,30));
        return tmp;
    }

    public List<Song> GetSongsByName(String n) {
        return songRepository.findByTitleContainingIgnoreCase(n);
    }


    public void HandleUploadSong(String originalFilename) {
        String songUrl = Const.MUSIC_DIR + ConvertStringToURL(originalFilename);
        Song temp = new Song(originalFilename,songUrl,1);
        songRepository.save(temp);
    }

    private String ConvertStringToURL(String input) {
        input = input.trim();
        // Replace All space (unicode is \\s) to %20
        input = input.replaceAll("\\s", "%20");
        return input;
    }

    public void HandleUploadMultipleSong(List<MultipartFile> lstFiles) {
        List<Song>  lstSongs = new ArrayList<>();
        String title = "";
        for (MultipartFile song:lstFiles) {
            title = song.getOriginalFilename();
            title = title.substring(0,title.indexOf("-"));

            lstSongs.add(new Song(title,
                    Const.MUSIC_DIR + ConvertStringToURL(song.getOriginalFilename()),1));
        }
        songRepository.saveAll(lstSongs);
    }
}
