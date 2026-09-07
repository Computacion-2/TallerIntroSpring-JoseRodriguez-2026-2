package com.example.config;

import com.example.repository.IArtistRepository;
import com.example.repository.ITrackRepository;
import com.example.repository.impl.ArtistRepositoryImpl;
import com.example.repository.impl.TrackRepositoryImpl;
import com.example.service.IArtistService;
import com.example.service.ITrackService;
import com.example.service.impl.ArtistServiceImpl;
import com.example.service.impl.TrackServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name = "artistRepository")
    public IArtistRepository artistRepository() {
        return new ArtistRepositoryImpl();
    }

    @Bean(name = "trackRepository")
    public ITrackRepository trackRepository() {
        return new TrackRepositoryImpl();
    }

    @Bean(name = "artistService")
    public IArtistService artistService() {
        return new ArtistServiceImpl(artistRepository());
    }

    @Bean(name = "trackService")
    public ITrackService trackService() {
        return new TrackServiceImpl(trackRepository(), artistRepository());
    }

    @Bean(name = "dataInitializer", initMethod = "init")
    public DataInitializer dataInitializer() {
        return new DataInitializer(artistService(), trackService());
    }
}
