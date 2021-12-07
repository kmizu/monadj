package com.github.kmizu.monadj;

import java.util.function.Function;

public interface Program<T> {
    T run();

    default <U> Program<U> bind(Function<T, Program<U>> fun) {
        return () -> {
            var value = this.run();
            return fun.apply(value).run();
        };
    }

    default <U> Program<U> map(Function<T, U> fun) {
        return () -> {
            var value = this.run();
            return fun.apply(value);
        };
    }

    default <U> Program<U> seq(Program<U> prog) {
        return () -> {
            this.run();
            return prog.run();
        };
    }

    static <T> Program<T> make(T value) {
        return (Program<T>)(() -> value);
    }
}
