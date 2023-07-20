package com.example.MyOwnMP3.Repository;

import com.example.MyOwnMP3.Model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist,Integer> {
}
