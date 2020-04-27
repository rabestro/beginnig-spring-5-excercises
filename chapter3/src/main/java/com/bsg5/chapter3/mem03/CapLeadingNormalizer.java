package com.bsg5.chapter3.mem03;

import com.bsg5.chapter3.Normalizer;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component("bar")
public class CapLeadingNormalizer implements Normalizer {
    @Override
    public String transform(String input) {
        return Arrays.stream(input.trim().split("\\s+"))
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }
}