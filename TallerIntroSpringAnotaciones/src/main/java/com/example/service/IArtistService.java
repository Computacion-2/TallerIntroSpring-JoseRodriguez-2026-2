package com.example.service;

import com.example.model.Artist;

import java.util.List;
import java.util.Optional;

public interface IArtistService {
    List<Artist> findAll();
    Artist save(Artist artist);
    Optional<Artist> findById(String id);
    Optional<Artist> findByNameWithTracks(String name);
    boolean deleteById(String id);
}
