package com.example.carlosottoboni.bookcase.bookdetail;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.carlosottoboni.bookcase.R;

public class BookDetailActivity extends AppCompatActivity {

    public static final String KEY_COMIC_BOOK_TITLE = "key_comic_book_title";
    private String title = "default_title";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            title = extras.getString(KEY_COMIC_BOOK_TITLE);
        }

        BookDetailFragment bookFragment = (BookDetailFragment) getSupportFragmentManager().findFragmentById(R.id
            .contentFrame);
        if (bookFragment == null) {
            bookFragment = BookDetailFragment.newInstance(title);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.contentFrame, bookFragment);
            transaction.commit();
        }
    }
}
