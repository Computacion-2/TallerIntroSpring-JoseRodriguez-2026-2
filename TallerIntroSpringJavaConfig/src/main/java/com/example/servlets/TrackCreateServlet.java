package com.example.servlets;

import com.example.model.Artist;
import com.example.model.Track;
import com.example.service.IArtistService;
import com.example.service.ITrackService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@WebServlet("/track-create")
public class TrackCreateServlet extends HttpServlet {

    private ITrackService trackService;
    private IArtistService artistService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        this.trackService = context.getBean("trackService", ITrackService.class);
        this.artistService = context.getBean("artistService", IArtistService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Artist> artists = artistService.findAll();
        req.setAttribute("artists", artists);
        req.getRequestDispatcher("/WEB-INF/views/track-form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String title = req.getParameter("title");
        String genre = req.getParameter("genre");
        String durationStr = req.getParameter("duration");
        String albumTitle = req.getParameter("albumTitle");
        String[] artistIdsParam = req.getParameterValues("artistIds");

        if (title != null && !title.trim().isEmpty()) {
            int duration = 0;
            try {
                if (durationStr != null && !durationStr.trim().isEmpty()) {
                    duration = Integer.parseInt(durationStr.trim());
                }
            } catch (NumberFormatException ignored) {}

            Track track = new Track();
            track.setTitle(title.trim());
            track.setGenre(genre != null ? genre.trim() : "");
            track.setDuration(duration);
            track.setAlbumTitle(albumTitle != null ? albumTitle.trim() : "");

            List<String> artistIds = (artistIdsParam != null) ? Arrays.asList(artistIdsParam) : Collections.emptyList();
            trackService.createTrackWithArtists(track, artistIds);
        }

        resp.sendRedirect(req.getContextPath() + "/tracks");
    }
}
