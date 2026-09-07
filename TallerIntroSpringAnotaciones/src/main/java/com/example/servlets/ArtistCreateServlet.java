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

@WebServlet("/artist-create")
public class ArtistCreateServlet extends HttpServlet {

    private IArtistService artistService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        this.artistService = context.getBean("artistService", IArtistService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/artist-form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String nationality = req.getParameter("nationality");

        if (name != null && !name.trim().isEmpty()) {
            Artist artist = new Artist();
            artist.setName(name.trim());
            artist.setNationality(nationality != null ? nationality.trim() : "");
            artistService.save(artist);
        }

        resp.sendRedirect(req.getContextPath() + "/artists");
    }
}
