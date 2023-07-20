package com.example.MyOwnMP3.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "playlists")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playlist_id")
    private Integer playlistId;

    @Column(name = "title")
    private String title;

    @Column(name = "artist_id")
    private Integer artistId;

    @Column(name = "songt_id")
    private Integer songtId;

    @Column(name = "love")
    private Integer love;
}

