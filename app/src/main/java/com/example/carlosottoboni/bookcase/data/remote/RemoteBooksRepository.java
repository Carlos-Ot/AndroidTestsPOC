package com.example.carlosottoboni.bookcase.data.remote;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.carlosottoboni.bookcase.data.Book;
import com.example.carlosottoboni.bookcase.data.BooksRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteBooksRepository implements BooksRepository {

    @Override
    public void getBooks(@NonNull final LoadBooksCallback callback) {
        ApiClient.createRequests().getComicBooks().enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                callback.onBooksLoaded(response.body());
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Log.d("carlosottoboni", "RemoteBooksRepository - onFailure");
            }
        });
    }

    @Override
    public void getBook(@NonNull int bookId, @NonNull GetBookCallback callback) {

    }

    @Override
    public void refreshData() {

    }
}
