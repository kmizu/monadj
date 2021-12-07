package com.github.kmizu.monadj;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class IOFunctions {
    private static final BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in)
    );

    public static Program<Void> pPrintln(String arg) {
        return () -> {
            System.out.println(arg);
            return null;
        };
    }

    public static final Program<String> pReadLine = () -> {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    };

    public static final Program<byte[]> pReadAllBytes = () -> {
        try {
            return System.in.readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    };

    public static Program<Void> pDeleteFile(String filePath) {
        return () -> {
            try {
                Files.delete(Path.of(filePath));
                return null;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static Program<List<String>> pReadAllLinesFromFile(String filePath) {
        return () -> {
            try {
                return Files.readAllLines(Path.of(filePath));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
