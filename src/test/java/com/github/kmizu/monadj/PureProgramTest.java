package com.github.kmizu.monadj;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static com.github.kmizu.monadj.Program.make;

public class PureProgramTest {
    @Test void simpleProgramShouldSucceed() {
        var program = make(1);
        var result = program.run();
        assertEquals(1, result.intValue());
    }

    @Test void simpleProgramUsingBindShouldSucceed() {
        var program = make(1);
        var result = program.bind(v -> make(v + 2)).run();
        assertEquals(3, result.intValue());
    }

    @Test void simpleProgramUsingMapShouldSucceed() {
        var program = make(2);
        var result = program.map(v -> v * 2).run();
        assertEquals(4, result.intValue());
    }

    @Test void simpleProgramUsingSeqShouldSucceed() {
        var program1 = make(3);
        var program2 = make(4);
        var result= program1.seq(program2).run();
        assertEquals(4, result.intValue());
    }
}
