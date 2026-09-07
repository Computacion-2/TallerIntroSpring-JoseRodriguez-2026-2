package com.example.config;

import com.example.model.Artist;
import com.example.model.Track;
import com.example.service.IArtistService;
import com.example.service.ITrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component("dataInitializer")
public class DataInitializer {

    private IArtistService artistService;
    private ITrackService trackService;

    public DataInitializer() {
    }

    @Autowired
    public DataInitializer(IArtistService artistService, ITrackService trackService) {
        this.artistService = artistService;
        this.trackService = trackService;
    }

    public void setArtistService(IArtistService artistService) {
        this.artistService = artistService;
    }

    public void setTrackService(ITrackService trackService) {
        this.trackService = trackService;
    }

    @PostConstruct
    public void init() {
        if (!artistService.findAll().isEmpty()) {
            return; // Ya inicializado
        }

        // 1. Crear 10 Artistas
        Artist a1 = artistService.save(new Artist("ART-001", "Shakira", "Colombia"));
        Artist a2 = artistService.save(new Artist("ART-002", "Bad Bunny", "Puerto Rico"));
        Artist a3 = artistService.save(new Artist("ART-003", "Michael Jackson", "Estados Unidos"));
        Artist a4 = artistService.save(new Artist("ART-004", "Queen", "Reino Unido"));
        Artist a5 = artistService.save(new Artist("ART-005", "Coldplay", "Reino Unido"));
        Artist a6 = artistService.save(new Artist("ART-006", "Karol G", "Colombia"));
        Artist a7 = artistService.save(new Artist("ART-007", "Daft Punk", "Francia"));
        Artist a8 = artistService.save(new Artist("ART-008", "Rosalia", "Espana"));
        Artist a9 = artistService.save(new Artist("ART-009", "Miles Davis", "Estados Unidos"));
        Artist a10 = artistService.save(new Artist("ART-010", "Taylor Swift", "Estados Unidos"));

        // 2. Crear 50 Tracks (5 por artista)
        
        // Shakira (5)
        createTrack("TRK-001", "Hips Don't Lie", "Pop Latin", 218, "Oral Fixation", List.of(a1.getId()));
        createTrack("TRK-002", "Waka Waka", "Pop", 202, "Listen Up!", List.of(a1.getId()));
        createTrack("TRK-003", "Antologia", "Pop Ballad", 254, "Pies Descalzos", List.of(a1.getId()));
        createTrack("TRK-004", "Ciega, Sordomuda", "Pop Rock", 268, "Donde Estan los Ladrones?", List.of(a1.getId()));
        createTrack("TRK-005", "Monotonia", "Bachata Pop", 158, "Las Mujeres Ya No Lloran", List.of(a1.getId()));

        // Bad Bunny (5)
        createTrack("TRK-006", "Titi Me Pregunto", "Urbano / Reggaeton", 243, "Un Verano Sin Ti", List.of(a2.getId()));
        createTrack("TRK-007", "Monaco", "Trap", 267, "Nadie Sabe Lo Que Va A Pasar Manana", List.of(a2.getId()));
        createTrack("TRK-008", "Dakiti", "Reggaeton", 205, "El Ultimo Tour Del Mundo", List.of(a2.getId()));
        createTrack("TRK-009", "Safaera", "Reggaeton", 295, "YHLQMDLG", List.of(a2.getId()));
        createTrack("TRK-010", "Ojitos Lindos", "Indie Pop / Urbano", 258, "Un Verano Sin Ti", List.of(a2.getId()));

        // Michael Jackson (5)
        createTrack("TRK-011", "Thriller", "Pop / Funk", 357, "Thriller", List.of(a3.getId()));
        createTrack("TRK-012", "Billie Jean", "Dance-Pop", 294, "Thriller", List.of(a3.getId()));
        createTrack("TRK-013", "Beat It", "Rock Pop", 258, "Thriller", List.of(a3.getId()));
        createTrack("TRK-014", "Smooth Criminal", "Funk Pop", 257, "Bad", List.of(a3.getId()));
        createTrack("TRK-015", "Bad", "Pop", 247, "Bad", List.of(a3.getId()));

        // Queen (5)
        createTrack("TRK-016", "Bohemian Rhapsody", "Operatic Rock", 354, "A Night at the Opera", List.of(a4.getId()));
        createTrack("TRK-017", "Don't Stop Me Now", "Pop Rock", 209, "Jazz", List.of(a4.getId()));
        createTrack("TRK-018", "Another One Bites the Dust", "Funk Rock", 215, "The Game", List.of(a4.getId()));
        createTrack("TRK-019", "Radio Ga Ga", "Synth Pop", 348, "The Works", List.of(a4.getId()));
        createTrack("TRK-020", "We Will Rock You", "Arena Rock", 122, "News of the World", List.of(a4.getId()));

        // Coldplay (5)
        createTrack("TRK-021", "Yellow", "Alternative Rock", 269, "Parachutes", List.of(a5.getId()));
        createTrack("TRK-022", "Viva La Vida", "Baroque Pop", 242, "Viva la Vida", List.of(a5.getId()));
        createTrack("TRK-023", "The Scientist", "Piano Rock", 309, "A Rush of Blood to the Head", List.of(a5.getId()));
        createTrack("TRK-024", "Fix You", "Post-Britpop", 295, "X&Y", List.of(a5.getId()));
        createTrack("TRK-025", "A Sky Full of Stars", "EDM Pop", 268, "Ghost Stories", List.of(a5.getId()));

        // Karol G (5)
        createTrack("TRK-026", "TQG", "Reggaeton", 199, "Manana Sera Bonito", List.of(a6.getId(), a1.getId()));
        createTrack("TRK-027", "PROVENZA", "Calypso Reggaeton", 210, "Manana Sera Bonito", List.of(a6.getId()));
        createTrack("TRK-028", "MAMIII", "Reggaeton", 227, "Manana Sera Bonito", List.of(a6.getId()));
        createTrack("TRK-029", "Bichota", "Reggaeton", 178, "KG0516", List.of(a6.getId()));
        createTrack("TRK-030", "Amargura", "Reggaeton", 170, "Manana Sera Bonito", List.of(a6.getId()));

        // Daft Punk (5)
        createTrack("TRK-031", "One More Time", "French House", 320, "Discovery", List.of(a7.getId()));
        createTrack("TRK-032", "Get Lucky", "Disco Funk", 248, "Random Access Memories", List.of(a7.getId()));
        createTrack("TRK-033", "Harder Better Faster Stronger", "Synthpop", 224, "Discovery", List.of(a7.getId()));
        createTrack("TRK-034", "Around the World", "House", 429, "Homework", List.of(a7.getId()));
        createTrack("TRK-035", "Instant Crush", "Electro Pop", 337, "Random Access Memories", List.of(a7.getId()));

        // Rosalia (5)
        createTrack("TRK-036", "MALAMENTE", "Flamenco Pop", 150, "El Mal Querer", List.of(a8.getId()));
        createTrack("TRK-037", "DESPECHA", "Merengue Pop", 157, "MOTOMAMI+", List.of(a8.getId()));
        createTrack("TRK-038", "SAOKO", "Experimental Reggaeton", 137, "MOTOMAMI", List.of(a8.getId()));
        createTrack("TRK-039", "Con Altura", "Reggaeton", 161, "Con Altura", List.of(a8.getId(), a2.getId()));
        createTrack("TRK-040", "LA FAMA", "Bachata", 188, "MOTOMAMI", List.of(a8.getId()));

        // Miles Davis (5)
        createTrack("TRK-041", "So What", "Modal Jazz", 562, "Kind of Blue", List.of(a9.getId()));
        createTrack("TRK-042", "Blue in Green", "Jazz", 337, "Kind of Blue", List.of(a9.getId()));
        createTrack("TRK-043", "Freddie Freeloader", "Blues Jazz", 589, "Kind of Blue", List.of(a9.getId()));
        createTrack("TRK-044", "All Blues", "Jazz", 693, "Kind of Blue", List.of(a9.getId()));
        createTrack("TRK-045", "Flamenco Sketches", "Modal Jazz", 566, "Kind of Blue", List.of(a9.getId()));

        // Taylor Swift (5)
        createTrack("TRK-046", "Love Story", "Country Pop", 235, "Fearless", List.of(a10.getId()));
        createTrack("TRK-047", "Blank Space", "Electropop", 231, "1989", List.of(a10.getId()));
        createTrack("TRK-048", "Shake It Off", "Dance Pop", 219, "1989", List.of(a10.getId()));
        createTrack("TRK-049", "Anti-Hero", "Synth Pop", 200, "Midnights", List.of(a10.getId()));
        createTrack("TRK-050", "Cruel Summer", "Synth Pop", 178, "Lover", List.of(a10.getId()));
    }

    private void createTrack(String id, String title, String genre, int duration, String albumTitle, List<String> artistIds) {
        Track track = new Track(id, title, genre, duration, albumTitle);
        trackService.createTrackWithArtists(track, artistIds);
    }
}
