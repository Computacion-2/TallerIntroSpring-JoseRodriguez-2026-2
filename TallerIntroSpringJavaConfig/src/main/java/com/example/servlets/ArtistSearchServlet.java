package com.example.servlets;

import com.example.model.Artist;
import com.example.service.IArtistService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/artist-search")
public class ArtistSearchServlet extends HttpServlet {

    private IArtistService artistService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        this.artistService = context.getBean("artistService", IArtistService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        if (name != null && !name.trim().isEmpty()) {
            Optional<Artist> artistOpt = artistService.findByNameWithTracks(name);
            if (artistOpt.isPresent()) {
                req.setAttribute("artist", artistOpt.get());
                req.setAttribute("found", true);
            } else {
                req.setAttribute("found", false);
                req.setAttribute("searchQuery", name);
            }
        }
        req.getRequestDispatcher("/WEB-INF/views/artist-search.jsp").forward(req, resp);
    }
}
