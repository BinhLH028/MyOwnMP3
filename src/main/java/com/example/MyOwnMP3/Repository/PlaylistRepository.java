package com.example.MyOwnMP3.Repository;

import com.example.MyOwnMP3.Model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist,Integer> {
}
