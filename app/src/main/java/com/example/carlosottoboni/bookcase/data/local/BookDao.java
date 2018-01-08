package com.example.carlosottoboni.bookcase.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.carlosottoboni.bookcase.data.Book;

import java.util.List;

@Dao
public interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertBooks(Book... books);

    @Update
    public void updateBooks(Book... books);

    @Delete
    public void deleteBooks(Book... books);

    @Query("SELECT * FROM books")
    public List<Book> getAllBooks();
}
