package com.example.carlosottoboni.bookcase.books;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.carlosottoboni.bookcase.R;
import com.example.carlosottoboni.bookcase.bookdetail.BookDetailActivity;
import com.example.carlosottoboni.bookcase.data.Book;

import java.util.ArrayList;
import java.util.List;

public class BookFragment extends Fragment implements BookContract.View {

    private int mColumnCount = 1;

    private BookContract.Presenter mPresenter;

    private BooksAdapter mAdapter;

    public BookFragment() {
    }

    public static BookFragment newInstance() {
        return new BookFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_book_list, container, false);

        mAdapter = new BooksAdapter(new ArrayList<Book>(0), mListener);

        View view = root.findViewById(R.id.list);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(mAdapter);
        }
        return root;
    }

    private BookItemListener mListener = new BookItemListener() {
        @Override
        public void onBookClick(Book item) {
            mPresenter.openBookDetail(item);
        }
    };

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter = null;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void setProgressIndicator(boolean active) {

    }

    @Override
    public void showBooks(List<Book> books) {
        mAdapter.replaceData(books, mListener);
    }

    @Override
    public void showBookDetail(Book book) {
        Intent intent = new Intent(getContext(), BookDetailActivity.class);
        intent.putExtra(BookDetailActivity.KEY_COMIC_BOOK_TITLE, book.getTitle());
        startActivity(intent);
    }

    @Override
    public void setPresenter(BookContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public interface BookItemListener {
        void onBookClick(Book item);
    }
}
