package com.example.MyOwnMP3.Repository;

import com.example.MyOwnMP3.Model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album,Integer> {
}
