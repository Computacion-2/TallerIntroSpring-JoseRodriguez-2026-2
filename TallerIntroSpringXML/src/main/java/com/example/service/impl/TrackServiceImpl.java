package com.example.service.impl;

import com.example.model.Artist;
import com.example.model.Track;
import com.example.repository.IArtistRepository;
import com.example.repository.ITrackRepository;
import com.example.service.ITrackService;

import java.util.List;
import java.util.Optional;

public class TrackServiceImpl implements ITrackService {

    private ITrackRepository trackRepository;
    private IArtistRepository artistRepository;

    public TrackServiceImpl() {
    }

    public TrackServiceImpl(ITrackRepository trackRepository, IArtistRepository artistRepository) {
        this.trackRepository = trackRepository;
        this.artistRepository = artistRepository;
    }

    public void setTrackRepository(ITrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public void setArtistRepository(IArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Track> findAll() {
        return trackRepository.findAll();
    }

    @Override
    public Track createTrackWithArtists(Track track, List<String> artistIds) {
        Track savedTrack = trackRepository.save(track);
        if (artistIds != null) {
            for (String artistId : artistIds) {
                Optional<Artist> artistOpt = artistRepository.findById(artistId);
                artistOpt.ifPresent(savedTrack::addArtist);
            }
        }
        return savedTrack;
    }

    @Override
    public Track save(Track track) {
        return trackRepository.save(track);
    }

    @Override
    public Optional<Track> findById(String id) {
        return trackRepository.findById(id);
    }

    @Override
    public boolean deleteById(String id) {
        return trackRepository.deleteById(id);
    }
}
