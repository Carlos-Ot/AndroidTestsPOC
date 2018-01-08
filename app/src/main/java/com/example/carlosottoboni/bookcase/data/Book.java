package com.example.carlosottoboni.bookcase.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "books")
public final class Book {
    @PrimaryKey
    @SerializedName("comic_book_id")
    @ColumnInfo(name = "comic_book_id")
    @Expose
    public int id;

    @SerializedName("volume")
    @ColumnInfo(name = "volume")
    @Expose
    private int volume;

    @SerializedName("title")
    @ColumnInfo(name = "title")
    @Expose
    private String title;

    @SerializedName("comic_book_spine")
    @ColumnInfo(name = "comic_book_spine")
    @Expose
    private String comicBookSpine;

    @SerializedName("comic_book_url")
    @ColumnInfo(name = "comic_book_url")
    @Expose
    private String comicBookUrl;

    @SerializedName("read_order")
    @ColumnInfo(name = "read_order")
    @Expose
    private int readOrder;

    @SerializedName("collection")
    @ColumnInfo(name = "collection")
    @Expose
    private String collection;

    @SerializedName("img_large")
    @ColumnInfo(name = "img_large")
    @Expose
    private String imgLarge;

    @SerializedName("img_small")
    @ColumnInfo(name = "img_small")
    @Expose
    private String imgSmall;

    @VisibleForTesting
    public Book(String title, String imgUrl) {
        this.setTitle(title);
        this.setImgSmall(imgUrl);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComicBookSpine() {
        return comicBookSpine;
    }

    public void setComicBookSpine(String comicBookSpine) {
        this.comicBookSpine = comicBookSpine;
    }

    public String getComicBookUrl() {
        return comicBookUrl;
    }

    public void setComicBookUrl(String comicBookUrl) {
        this.comicBookUrl = comicBookUrl;
    }

    public int getReadOrder() {
        return readOrder;
    }

    public void setReadOrder(int readOrder) {
        this.readOrder = readOrder;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getImgLarge() {
        return imgLarge;
    }

    public void setImgLarge(String imgLarge) {
        this.imgLarge = imgLarge;
    }

    public String getImgSmall() {
        return imgSmall;
    }

    public void setImgSmall(String imgSmall) {
        this.imgSmall = imgSmall;
    }
}
