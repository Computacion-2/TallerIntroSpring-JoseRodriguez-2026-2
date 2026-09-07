package com.example;

import com.example.config.AppConfig;
import com.example.model.Artist;
import com.example.model.Track;
import com.example.service.IArtistService;
import com.example.service.ITrackService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class SpringJavaConfigTest {

    @Test
    public void testSpringJavaConfiguration() {
        // Cargar el contenedor de Spring a través de la clase @Configuration AppConfig
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Obtener los beans declarados por métodos @Bean
        IArtistService artistService = context.getBean("artistService", IArtistService.class);
        ITrackService trackService = context.getBean("trackService", ITrackService.class);

        assertNotNull("El bean artistService no debe ser nulo", artistService);
        assertNotNull("El bean trackService no debe ser nulo", trackService);

        // Verificar la inicialización de los 10 artistas
        List<Artist> artists = artistService.findAll();
        assertEquals("Deben existir 10 artistas inicializados", 10, artists.size());

        // Verificar la inicialización de los 50 tracks
        List<Track> tracks = trackService.findAll();
        assertEquals("Deben existir 50 canciones inicializadas", 50, tracks.size());

        // Buscar artista por nombre y verificar sus canciones asociadas
        Optional<Artist> shakiraOpt = artistService.findByNameWithTracks("Shakira");
        assertTrue("Shakira debe estar registrada", shakiraOpt.isPresent());

        Artist shakira = shakiraOpt.get();
        assertEquals("Shakira", shakira.getName());
        assertEquals("Colombia", shakira.getNationality());
        assertTrue("Shakira debe tener canciones registradas", shakira.getTracks().size() >= 5);
    }
}
