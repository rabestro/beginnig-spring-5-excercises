package com.bsg5.chapter5;

import com.bsg5.chapter3.MusicService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.ApplicationContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.util.Objects.isNull;

@WebServlet(urlPatterns = "/songs")
public class GetSongsForArtistServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        var context = (ApplicationContext) req.getServletContext().getAttribute("context");
        var service = context.getBean(MusicService.class);
        var mapper = new ObjectMapper();
        var artist = req.getParameter("artist");
        if (isNull(artist)) {
            log("Missing data in request: requires artist parameter");
            resp.setStatus(500);
        } else {
            var data = service.getSongsForArtist(artist);
            resp.setStatus(200);
            resp.getWriter().println(mapper.writeValueAsString(data));
        }
    }
}