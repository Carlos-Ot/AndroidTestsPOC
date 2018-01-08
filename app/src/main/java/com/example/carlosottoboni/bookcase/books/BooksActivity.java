package com.example.carlosottoboni.bookcase.books;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.carlosottoboni.bookcase.Injection;
import com.example.carlosottoboni.bookcase.R;
import com.example.carlosottoboni.bookcase.data.Book;

import java.util.List;

public class BooksActivity extends AppCompatActivity {

    private BooksPresenter mBooksPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        BookFragment bookFragment = (BookFragment) getSupportFragmentManager().findFragmentById(R.id
            .contentFrame);
        if (bookFragment == null) {
            bookFragment = BookFragment.newInstance();

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.contentFrame, bookFragment);
            transaction.commit();
        }

        mBooksPresenter = new BooksPresenter(Injection.providesBooksRepository(), bookFragment);
    }
}
