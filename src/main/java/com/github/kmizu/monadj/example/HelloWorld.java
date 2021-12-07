package com.github.kmizu.monadj.example;

import com.github.kmizu.monadj.EntryPoint;
import static com.github.kmizu.monadj.IOFunctions.*;
import com.github.kmizu.monadj.Program;

public class HelloWorld implements EntryPoint<Void> {
    @Override
    public Program<Void> main() {
        return pPrintln("Hello, World!");
    }
}
