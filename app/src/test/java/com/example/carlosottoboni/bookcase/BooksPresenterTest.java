package com.example.carlosottoboni.bookcase;

import com.example.carlosottoboni.bookcase.books.BookContract;
import com.example.carlosottoboni.bookcase.books.BooksPresenter;
import com.example.carlosottoboni.bookcase.data.Book;
import com.example.carlosottoboni.bookcase.data.BooksRepository;
import com.google.common.collect.Lists;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class BooksPresenterTest {

    private static List<Book> BOOKS = Lists.newArrayList(new Book("DummyBook1","http://statics" +
        ".livrariacultura.net.br/products/capas/216/9131216.jpg" ),
        new Book("DummyBook2", "http://statics.livrariacultura.net.br/products/capas/216/9131216.jpg"));

    private static List<Book> EMPTY_BOOKS = new ArrayList<>(0);

    @Mock
    private BooksRepository mBooksRepository;

    @Mock
    private BookContract.View mBooksView;

    @Captor
    private ArgumentCaptor<BooksRepository.LoadBooksCallback> mLoadBooksCallbackCaptor;

    private BooksPresenter mBooksPresenter;

    @Before
    public void setupBooksPresenter() {
        MockitoAnnotations.initMocks(this);

        mBooksPresenter = new BooksPresenter(mBooksRepository, mBooksView);
    }

    @Test
    public void loadBooksFromWebServiceAndShow() {
        mBooksPresenter.loadBooks(true);

        Mockito.verify(mBooksRepository).getBooks(mLoadBooksCallbackCaptor.capture());
        mLoadBooksCallbackCaptor.getValue().onBooksLoaded(BOOKS);

        InOrder inOrder = Mockito.inOrder(mBooksView);
        inOrder.verify(mBooksView).setProgressIndicator(true);
        inOrder.verify(mBooksView).setProgressIndicator(false);
        Mockito.verify(mBooksView).showBooks(BOOKS);
    }

    @Test
    public void clickOnBook_ShowBookDetails() {
        Book requestedBook = new Book("Requested Book", "Url");

        mBooksPresenter.openBookDetail(requestedBook);

        Mockito.verify(mBooksView).showBookDetail(Mockito.any(Book.class));
    }
}
