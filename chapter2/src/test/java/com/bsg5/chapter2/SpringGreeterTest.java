package com.bsg5.chapter2;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

import static org.testng.Assert.assertEquals;

public class SpringGreeterTest {
    @Test
    public void testHelloWorld() {
        final var context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        final var greeter = context.getBean("helloGreeter", Greeter.class);

        final var baos = context.getBean("baos", ByteArrayOutputStream.class);
        greeter.greet();
        final var data = new String(baos.toByteArray(), StandardCharsets.UTF_8);

        assertEquals(data, "Hello, World!");
    }
}