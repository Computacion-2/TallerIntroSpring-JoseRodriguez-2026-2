package com.example.servlets;

import com.example.service.ITrackService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/track-delete")
public class TrackDeleteServlet extends HttpServlet {

    private ITrackService trackService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        this.trackService = context.getBean("trackService", ITrackService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null && !id.trim().isEmpty()) {
            trackService.deleteById(id.trim());
        }
        resp.sendRedirect(req.getContextPath() + "/tracks");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
