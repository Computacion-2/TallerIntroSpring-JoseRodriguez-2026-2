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
import java.util.List;

@WebServlet("/artists")
public class ArtistListServlet extends HttpServlet {

    private IArtistService artistService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        this.artistService = context.getBean("artistService", IArtistService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Artist> artists = artistService.findAll();
        req.setAttribute("artists", artists);
        req.getRequestDispatcher("/WEB-INF/views/artist-list.jsp").forward(req, resp);
    }
}
