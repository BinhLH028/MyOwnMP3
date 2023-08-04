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
    private Integer songId;
    @Column(name = "title")
    private String title;
    @Column(name = "duration")
    private Integer duration;
    @Column(name = "song_url")
    private String songUrl;
    @Column(name = "artist_id")
    private Integer artistId;
    @Column(name = "genre_id")
    private Integer genreId;
    @Column(name = "album_id")
    private Integer albumId;
    @Column(name = "playlist_id")
    private Integer playlistId;
    @Column(name = "love")
    private Integer love;

    public Song(String title, String songUrl, Integer artistId) {
        this.title = title;
        this.songUrl = songUrl;
        this.artistId = artistId;
    }
}
