package com.spryrocks.imgsearch.presentation.mvvm.ui.utils;

public class Monads {
    public static <T> void maybeNull(T value, Action1<T> action) {
        if (value != null) action.run(value);
    }

    public interface Action1<T> {
        void run(T arg);
    }
}
