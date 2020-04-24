package com.bsg5.chapter2;

import org.springframework.stereotype.Service;
import java.io.PrintStream;

public class HelloWorldGreeter implements Greeter {
    private PrintStream out;

    public void setPrintStream(PrintStream printStream) {
        this.out = printStream;
    }

    public void greet() {
        out.print("Hello, World!");
    }
}
