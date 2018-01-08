package com.example.carlosottoboni.bookcase.books;

import android.support.annotation.NonNull;

import com.example.carlosottoboni.bookcase.data.Book;
import com.example.carlosottoboni.bookcase.data.BooksRepository;

import java.util.ArrayList;
import java.util.List;

public class BooksPresenter implements BookContract.Presenter {

    private final BooksRepository mBooksRepository;
    private final BookContract.View mBooksView;

    public BooksPresenter(@NonNull BooksRepository booksRepository, @NonNull BookContract.View booksView) {
        mBooksRepository = booksRepository;
        mBooksView = booksView;

        mBooksView.setPresenter(this);
    }

    @Override
    public void loadBooks(boolean forceUpdate) {
        mBooksView.setProgressIndicator(true);

        mBooksRepository.getBooks(new BooksRepository.LoadBooksCallback() {
            @Override
            public void onBooksLoaded(List<Book> books) {
                List<Book> filteredBooks = new ArrayList<>();
                if (books != null) {
                    for (Book book : books) {
                        if (book.getImgSmall() != null) {
                            filteredBooks.add(book);
                        }
                    }
                }
                mBooksView.setProgressIndicator(false);
                mBooksView.showBooks(filteredBooks);
            }
        });
    }

    @Override
    public void openBookDetail(@NonNull Book requestedBook) {
        mBooksView.showBookDetail(requestedBook);
    }

    @Override
    public void start() {
        loadBooks(false);
    }
}
