package com.example.MyOwnMP3.Model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
}
