package com.example.carlosottoboni.bookcase.data.remote;

import com.example.carlosottoboni.bookcase.data.Book;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRequest {

    @GET("/comic_books")
    Call<List<Book>> getComicBooks();
}
