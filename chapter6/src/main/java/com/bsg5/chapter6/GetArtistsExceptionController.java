package com.bsg5.chapter6;

import com.bsg5.chapter3.MusicService;
import com.bsg5.chapter3.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GetArtistsExceptionController {

    @Autowired
    MusicService service;

    @GetMapping("/artists/{artist}")
    @ResponseBody
    public ResponseEntity<Artist> getSong(
            @PathVariable("artist") final String artist
    ) {
        throw new ArtistNotFoundException("Artist with name " + artist + " not found");
    }

    @ExceptionHandler(ArtistNotFoundException.class)
    public ModelAndView handleCustomException(ArtistNotFoundException ex) {
        return new ModelAndView("error")
                .addObject("message", ex.getMessage())
                .addObject("statusCode", 404);

    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllExceptions(Exception ex) {
        return new ModelAndView("error")
                .addObject("message", ex.getMessage())
                .addObject("statusCode", 500);
    }

}
