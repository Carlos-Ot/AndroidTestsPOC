package com.example.carlosottoboni.bookcase.data;

import com.example.carlosottoboni.bookcase.data.remote.RemoteBooksRepository;

public class BookRepositories {

    private BookRepositories() {

    }

    private static BooksRepository repository = null;

    public synchronized static BooksRepository getRepository() {

        if (repository == null) {
            repository = new RemoteBooksRepository();
        }

        return repository;
    }
}
