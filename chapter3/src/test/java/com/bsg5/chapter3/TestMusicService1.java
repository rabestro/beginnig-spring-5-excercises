package com.bsg5.chapter3;

import com.bsg5.chapter3.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

@ContextConfiguration(locations = "/config-01.xml")
public class TestMusicService1 extends AbstractTestNGSpringContextTests {
    @Autowired
    ApplicationContext context;
    @Autowired
    MusicService service;

    @Test
    public void testConfiguration() {
        assertNotNull(context);

        var definitions = Set.of(context.getBeanDefinitionNames());

        // uncomment if you'd like to see the entire set of defined beans
        definitions.forEach(System.out::println);

        assertTrue(definitions.contains("musicService1"));
    }

    @Test
    public void testMusicService() {
        Song song = service.getSong(
                "Threadbare Loaf", "Someone Stole the Flour"
        );
        assertEquals(song.getVotes(), 0);
    }
}