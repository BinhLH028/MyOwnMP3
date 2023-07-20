package com.example.MyOwnMP3.Repository;

import com.example.MyOwnMP3.Model.Song;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends PagingAndSortingRepository<Song, Integer> {

}
