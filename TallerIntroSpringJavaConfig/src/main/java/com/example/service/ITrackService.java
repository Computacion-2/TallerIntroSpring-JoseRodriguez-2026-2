package com.example.service;

import com.example.model.Track;

import java.util.List;
import java.util.Optional;

public interface ITrackService {
    List<Track> findAll();
    Track createTrackWithArtists(Track track, List<String> artistIds);
    Track save(Track track);
    Optional<Track> findById(String id);
    boolean deleteById(String id);
}
