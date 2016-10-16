package com.demodb.model;

import android.database.sqlite.SQLiteDatabase;

import com.demodb.BookModel;
import com.google.auto.value.AutoValue;
import com.squareup.sqldelight.RowMapper;

/**
 * Created by ANISH on 16-10-2016.
 */
@AutoValue
public abstract class Book implements BookModel
{
    public static final Factory<Book> FACTORY= new Factory<>(AutoValue_Book::new);
    public static final RowMapper<Book> MAPPER= FACTORY.select_all_booksMapper();

    //public static void insert(SQLiteDatabase db,
}