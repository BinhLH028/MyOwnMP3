package com.example.MyOwnMP3.Model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "song_id")
    private Integer song_id;
    @Column(name = "title")
    private String title;
    @Column(name = "duration")
    private Integer duration;
    @Column(name = "song_url")
    private String song_url;
    @Column(name = "artist_id")
    private Integer artist_id;
    @Column(name = "genre_id")
    private Integer genre_id;
    @Column(name = "album_id")
    private Integer album_id;
    @Column(name = "playlist_id")
    private Integer playlist_id;
    @Column(name = "love")
    private Integer love;

    public Song(String title, String song_url, Integer artist_id) {
        this.title = title;
        this.song_url = song_url;
        this.artist_id = artist_id;
    }
}
