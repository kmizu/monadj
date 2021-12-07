package com.github.kmizu.monadj;

import com.github.kmizu.monadj.example.HelloWorld;

public class Main {
    public static void main(String[] args) {
        var program = new HelloWorld();
        program.main().run();
    }
}
