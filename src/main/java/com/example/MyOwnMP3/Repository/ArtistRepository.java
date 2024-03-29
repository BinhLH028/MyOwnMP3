package com.example.MyOwnMP3.Repository;

import com.example.MyOwnMP3.Model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist,Integer> {


    List<Artist> findByArtistNameContainingIgnoreCase(String n);
}
