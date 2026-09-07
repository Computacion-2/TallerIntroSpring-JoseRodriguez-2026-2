package com.example.service.impl;

import com.example.model.Artist;
import com.example.repository.IArtistRepository;
import com.example.service.IArtistService;

import java.util.List;
import java.util.Optional;

public class ArtistServiceImpl implements IArtistService {

    private IArtistRepository artistRepository;

    public ArtistServiceImpl() {
    }

    public ArtistServiceImpl(IArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public void setArtistRepository(IArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Artist> findAll() {
        return artistRepository.findAll();
    }

    @Override
    public Artist save(Artist artist) {
        return artistRepository.save(artist);
    }

    @Override
    public Optional<Artist> findById(String id) {
        return artistRepository.findById(id);
    }

    @Override
    public Optional<Artist> findByNameWithTracks(String name) {
        return artistRepository.findByNameWithTracks(name);
    }

    @Override
    public boolean deleteById(String id) {
        return artistRepository.deleteById(id);
    }
}
