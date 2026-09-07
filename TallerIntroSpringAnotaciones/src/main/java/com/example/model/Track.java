package com.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Track {
    private String id;
    private String title;
    private String genre;
    private int duration; // Duración en segundos
    private String albumTitle;
    private List<Artist> artists;

    public Track() {
        this.artists = new ArrayList<>();
    }

    public Track(String id, String title, String genre, int duration, String albumTitle) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.albumTitle = albumTitle;
        this.artists = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public void addArtist(Artist artist) {
        if (artist != null && !this.artists.contains(artist)) {
            this.artists.add(artist);
            if (!artist.getTracks().contains(this)) {
                artist.getTracks().add(this);
            }
        }
    }

    public void removeArtist(Artist artist) {
        if (artist != null && this.artists.contains(artist)) {
            this.artists.remove(artist);
            artist.getTracks().remove(this);
        }
    }

    /**
     * Formatea la duración en segundos a formato MM:SS
     */
    public String getFormattedDuration() {
        int minutes = duration / 60;
        int seconds = duration % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return Objects.equals(id, track.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Track{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", duration=" + duration +
                ", albumTitle='" + albumTitle + '\'' +
                ", totalArtists=" + (artists != null ? artists.size() : 0) +
                '}';
    }
}
