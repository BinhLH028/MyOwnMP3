package com.example.MyOwnMP3.Repository;

import com.example.MyOwnMP3.Model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends PagingAndSortingRepository<Song, Integer> {

    @Query(value = """
            SELECT s FROM Song s
            WHERE s.title LIKE %:name%
            ORDER BY s.id
            LIMIT 5
            """
            )
    List<Song> FindSongsByName(String name);
}
