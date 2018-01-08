package com.example.carlosottoboni.bookcase;

import com.example.carlosottoboni.bookcase.data.BookRepositories;
import com.example.carlosottoboni.bookcase.data.BooksRepository;

public class Injection {

    public static BooksRepository providesBooksRepository() {
        return BookRepositories.getRepository();
    }
}
