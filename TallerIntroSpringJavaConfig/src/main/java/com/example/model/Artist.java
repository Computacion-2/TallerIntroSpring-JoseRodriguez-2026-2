package com.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Artist {
    private String id;
    private String name;
    private String nationality;
    private List<Track> tracks;

    public Artist() {
        this.tracks = new ArrayList<>();
    }

    public Artist(String id, String name, String nationality) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.tracks = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public void addTrack(Track track) {
        if (track != null && !this.tracks.contains(track)) {
            this.tracks.add(track);
            if (!track.getArtists().contains(this)) {
                track.getArtists().add(this);
            }
        }
    }

    public void removeTrack(Track track) {
        if (track != null && this.tracks.contains(track)) {
            this.tracks.remove(track);
            track.getArtists().remove(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return Objects.equals(id, artist.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", totalTracks=" + (tracks != null ? tracks.size() : 0) +
                '}';
    }
}
