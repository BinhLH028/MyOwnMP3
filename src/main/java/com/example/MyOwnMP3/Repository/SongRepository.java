package com.example.MyOwnMP3.Repository;

import com.example.MyOwnMP3.Model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {


    List<Song> findByNameContainingIgnoreCase(String n);
}
