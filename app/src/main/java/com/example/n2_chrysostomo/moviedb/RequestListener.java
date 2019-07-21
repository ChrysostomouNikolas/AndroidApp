package com.example.n2_chrysostomo.moviedb;

public interface RequestListener<T> {
    void getResult(T object);
}
