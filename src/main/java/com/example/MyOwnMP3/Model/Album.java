package com.example.MyOwnMP3.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "albums")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id")
    private Integer albumId;

    @Column(name = "title")
    private String title;

    @Column(name = "artist_id")
    private Integer artistId;

    @Column(name = "song_id")
    private Integer songId;

    @Column(name = "love")
    private Integer love;
}

