package com.example.MyOwnMP3.Repository;

import com.example.MyOwnMP3.Model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre,Integer> {
}
