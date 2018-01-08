package com.example.carlosottoboni.bookcase.books;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.carlosottoboni.bookcase.R;
import com.example.carlosottoboni.bookcase.data.Book;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder> {

    private List<Book> mValues;
    private BookFragment.BookItemListener mListener;

    public BooksAdapter(List<Book> items, BookFragment.BookItemListener listener) {
        mValues = items;
        mListener = listener;
    }

    public void replaceData(List<Book> books, BookFragment.BookItemListener listener) {
        setData(books);
        notifyDataSetChanged();
    }

    public void setData(List<Book> books) {
        mValues = books;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.fragment_book, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mTitleView.setText(mValues.get(position).getTitle());

        String url = mValues.get(position).getImgSmall();
        Log.d("ImgURL", "Img: " + mValues.get(position).getImgSmall());
        if (url != null) {
            Uri uri = Uri.parse(url);
            holder.mImageView.setImageURI(uri);
        }

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onBookClick(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final SimpleDraweeView mImageView;
        public final TextView mTitleView;
        public Book mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mImageView = (SimpleDraweeView) view.findViewById(R.id.coverImg);
            mTitleView = (TextView) view.findViewById(R.id.comicTitle);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTitleView.getText() + "'";
        }
    }
}
