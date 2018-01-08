package com.example.carlosottoboni.bookcase.bookdetail;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.carlosottoboni.bookcase.R;

import org.w3c.dom.Text;

public class BookDetailFragment extends Fragment {

    private static final String ARG_TITLE = "title";
    private String comicBookTitle;


    public BookDetailFragment() {
        // Required empty public constructor
    }

    public static BookDetailFragment newInstance(String title) {
        BookDetailFragment fragment = new BookDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            comicBookTitle = getArguments().getString(ARG_TITLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_book_detail, container, false);

        TextView textTitle = root.findViewById(R.id.textContainer);

        textTitle.setText(comicBookTitle);

        return root;
    }

}
