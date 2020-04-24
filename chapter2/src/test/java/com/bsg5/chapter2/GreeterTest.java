package com.bsg5.chapter2;

import org.testng.annotations.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import static org.testng.Assert.assertEquals;

public class GreeterTest {
    @Test
    public void testHelloWorld() {
        Greeter greeter = new HelloWorldGreeter();
        final var baos = new ByteArrayOutputStream();
        try (final var ps = new PrintStream(baos, true, "UTF-8")) {
            greeter.setPrintStream(ps);
            greeter.greet();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        final var data = new String(baos.toByteArray(), StandardCharsets.UTF_8);
        assertEquals(data, "Hello, World!");
    }
}
