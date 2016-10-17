package com.demodb;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.demodb.db_helper.BooksOpenHelper;
import com.demodb.db_helper.DatabaseManager;
import com.demodb.model.Book;
import com.demodb.model.BookRequest;

public class MainActivity extends AppCompatActivity {

    Button btn_u,btn_i,btn_d,btn_nxt;
    EditText name, price;

    Book bk;
    private String book_name;
    int book_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.book_name);
        price = (EditText) findViewById(R.id.book_price);
        btn_u = (Button) findViewById(R.id.update_btn);
        btn_i=(Button)findViewById(R.id.insert_btn);
        btn_d=(Button)findViewById(R.id.delete_btn);
        btn_nxt=(Button)findViewById(R.id.nxt_btn);


        btn_i.setOnClickListener(v -> {
            book_name = name.getText().toString();
            book_price = Integer.parseInt(price.getText().toString());
            //Book.insertInBook(book_name, book_price);
            BookRequest bookRequest = new BookRequest();
            bookRequest.setBook_name(book_name);
            bookRequest.setBook_price(book_price);
            Book.insertInBook(bookRequest);
        });



        btn_u.setOnClickListener(v -> {
            book_name = name.getText().toString();
            book_price = Integer.parseInt(price.getText().toString());
           //Book.insertInBook(book_name, book_price);
            BookRequest bookRequest = new BookRequest();
            bookRequest.setBook_name(book_name);
            bookRequest.setBook_price(book_price);
            bookRequest.setBook_id(1);
            Book.updateInBook(bookRequest);



        });

        btn_d.setOnClickListener(v -> {
            book_name = name.getText().toString();
            BookRequest bookRequest = new BookRequest();
            bookRequest.setBook_name(book_name);
            Book.deleteData(bookRequest);

        });

        btn_nxt.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(),BookListActivity.class));
        });


    }




}

