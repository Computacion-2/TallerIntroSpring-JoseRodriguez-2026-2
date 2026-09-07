package com.example.repository;

import com.example.model.Track;
import java.util.List;
import java.util.Optional;

public interface ITrackRepository {
    List<Track> findAll();
    Track save(Track track);
    Optional<Track> findById(String id);
    boolean deleteById(String id);
}
