package com.example.repository.impl;

import com.example.model.Artist;
import com.example.model.Track;
import com.example.repository.IArtistRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository("artistRepository")
public class ArtistRepositoryImpl implements IArtistRepository {

    private final Map<String, Artist> artistStore = new ConcurrentHashMap<>();

    @Override
    public List<Artist> findAll() {
        return new ArrayList<>(artistStore.values());
    }

    @Override
    public Artist save(Artist artist) {
        if (artist.getId() == null || artist.getId().trim().isEmpty()) {
            artist.setId("ART-" + System.currentTimeMillis() + "-" + (int)(Math.random() * 1000));
        }
        artistStore.put(artist.getId(), artist);
        return artist;
    }

    @Override
    public Optional<Artist> findById(String id) {
        return Optional.ofNullable(artistStore.get(id));
    }

    @Override
    public Optional<Artist> findByNameWithTracks(String name) {
        if (name == null || name.trim().isEmpty()) {
            return Optional.empty();
        }
        String searchName = name.trim().toLowerCase();
        return artistStore.values().stream()
                .filter(artist -> artist.getName().toLowerCase().contains(searchName))
                .findFirst();
    }

    @Override
    public boolean deleteById(String id) {
        Artist removedArtist = artistStore.remove(id);
        if (removedArtist != null) {
            if (removedArtist.getTracks() != null) {
                for (Track track : new ArrayList<>(removedArtist.getTracks())) {
                    track.getArtists().remove(removedArtist);
                }
            }
            return true;
        }
        return false;
    }
}
