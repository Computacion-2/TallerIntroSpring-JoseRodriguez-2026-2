package com.example.repository.impl;

import com.example.model.Artist;
import com.example.model.Track;
import com.example.repository.ITrackRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository("trackRepository")
public class TrackRepositoryImpl implements ITrackRepository {

    private final Map<String, Track> trackStore = new ConcurrentHashMap<>();

    @Override
    public List<Track> findAll() {
        return new ArrayList<>(trackStore.values());
    }

    @Override
    public Track save(Track track) {
        if (track.getId() == null || track.getId().trim().isEmpty()) {
            track.setId("TRK-" + System.currentTimeMillis() + "-" + (int)(Math.random() * 1000));
        }
        trackStore.put(track.getId(), track);
        return track;
    }

    @Override
    public Optional<Track> findById(String id) {
        return Optional.ofNullable(trackStore.get(id));
    }

    @Override
    public boolean deleteById(String id) {
        Track removedTrack = trackStore.remove(id);
        if (removedTrack != null) {
            if (removedTrack.getArtists() != null) {
                for (Artist artist : new ArrayList<>(removedTrack.getArtists())) {
                    artist.getTracks().remove(removedTrack);
                }
            }
            return true;
        }
        return false;
    }
}
