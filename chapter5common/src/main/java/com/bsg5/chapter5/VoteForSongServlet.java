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

@WebServlet(urlPatterns = "/vote")
public class VoteForSongServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        var context = (ApplicationContext) req
                .getServletContext()
                .getAttribute("context");
        var service = context.getBean(MusicService.class);
        var mapper = new ObjectMapper();
        var artist = req.getParameter("artist");
        var song = req.getParameter("song");
        if (isNull(artist) || isNull(song)) {
            log("Missing data in request: requires artist and song parameters");
            resp.setStatus(500);
        } else {
            log("Voting for artist " + artist + ", song " + song);
            service.voteForSong(artist, song);
            resp.setStatus(200);
            resp.getWriter().println(mapper.writeValueAsString(service.getSong(artist, song))
            );
        }
    }
}