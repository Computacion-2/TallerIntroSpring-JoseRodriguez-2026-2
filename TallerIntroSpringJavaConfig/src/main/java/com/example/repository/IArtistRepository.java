package com.example.repository;

import com.example.model.Artist;
import java.util.List;
import java.util.Optional;

public interface IArtistRepository {
    List<Artist> findAll();
    Artist save(Artist artist);
    Optional<Artist> findById(String id);
    Optional<Artist> findByNameWithTracks(String name);
    boolean deleteById(String id);
}
