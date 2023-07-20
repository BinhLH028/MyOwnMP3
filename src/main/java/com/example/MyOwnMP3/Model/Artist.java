package com.example.MyOwnMP3.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Column(name = "artist_id")
    private Integer artist_id;
    @Column(name = "age")
    private Integer age;
    @Column(name = "gender")
    private Integer gender;
    @Column(name = "company_id")
    private Integer company_id;
    @Column(name = "genre_id")
    private Integer genre_id;
    @Column(name = "album_id")
    private Integer album_id;
    @Column(name = "playlist_id")
    private Integer playlist_id;
    @Column(name = "love")
    private Integer love;

}
