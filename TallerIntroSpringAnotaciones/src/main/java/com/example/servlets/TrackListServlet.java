package com.example.servlets;

import com.example.model.Track;
import com.example.service.ITrackService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/tracks")
public class TrackListServlet extends HttpServlet {

    private ITrackService trackService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        this.trackService = context.getBean("trackService", ITrackService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Track> tracks = trackService.findAll();
        req.setAttribute("tracks", tracks);
        req.getRequestDispatcher("/WEB-INF/views/track-list.jsp").forward(req, resp);
    }
}
