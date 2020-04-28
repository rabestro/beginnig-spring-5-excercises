package com.bsg5.chapter3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

public class MusicServiceRunner {
    public static void main(String[] args) {
        Class<?>[] configurations = new Class<?>[]{Configuration7.class, TestConfiguration.class};

        final var context = new AnnotationConfigApplicationContext(configurations);

        Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
}