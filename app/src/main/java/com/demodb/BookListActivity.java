package com.demodb;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.demodb.adapters.bookAdapters;
import com.demodb.model.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anish on 17-10-2016.
 */
public class BookListActivity extends AppCompatActivity
{
    RecyclerView book_list;
    List<Book> books;
    bookAdapters ba;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booklist);
        book_list=(RecyclerView)findViewById(R.id.book_list);

        books= new ArrayList<>();

        books=Book.getAllBookDetails();
        Log.e("size-->", "onCreate: "+books.size());

        ba= new bookAdapters(this,books);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        book_list.setLayoutManager(mLayoutManager);

        if(books.isEmpty())
        {
            Toast.makeText(BookListActivity.this, "List is empty", Toast.LENGTH_SHORT).show();
        }
        else
        {
            book_list.setAdapter(ba);
        }
    }
}
