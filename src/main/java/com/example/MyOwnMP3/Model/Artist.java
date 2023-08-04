package com.example.MyOwnMP3.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "artists")
public class Artist {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "artist_id")
    private Integer artistId;
    @Column(name = "artist_name")
    private String artistName;
    @Column(name = "age")
    private Integer age;
    @Column(name = "gender")
    private Integer gender;
    @Column(name = "company_id")
    private Integer companyId;
    @Column(name = "genre_id")
    private Integer genreId;
    @Column(name = "album_id")
    private Integer albumId;
    @Column(name = "playlist_id")
    private Integer playlistId;
    @Column(name = "love")
    private Integer love;

    public Artist(String artist_name, Integer age, Integer gender) {
        this.artistName = artist_name;
        this.age = age;
        this.gender = gender;
    }
}
