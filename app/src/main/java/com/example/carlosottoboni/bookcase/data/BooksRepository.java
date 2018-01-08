package com.example.carlosottoboni.bookcase.data;

import android.support.annotation.NonNull;

import java.util.List;

public interface BooksRepository {

    interface LoadBooksCallback {

        void onBooksLoaded(List<Book> books);
    }

    interface GetBookCallback {
        void onBookLoaded(Book book);
    }

    void getBooks(@NonNull LoadBooksCallback callback);

    void getBook(@NonNull int bookId, @NonNull GetBookCallback callback);

    void refreshData();
}
