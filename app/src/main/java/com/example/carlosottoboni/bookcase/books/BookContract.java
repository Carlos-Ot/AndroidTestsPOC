package com.example.carlosottoboni.bookcase.books;

import android.support.annotation.NonNull;

import com.example.carlosottoboni.bookcase.BasePresenter;
import com.example.carlosottoboni.bookcase.BaseView;
import com.example.carlosottoboni.bookcase.data.Book;

import java.util.List;

public interface BookContract {

    interface View extends BaseView<Presenter> {

        void setProgressIndicator(boolean active);

        void showBooks(List<Book> books);

        void showBookDetail(Book book);
    }

    interface Presenter extends BasePresenter {

        void loadBooks(boolean forceUpdate);

        void openBookDetail(@NonNull Book requestedBook);

    }
}
