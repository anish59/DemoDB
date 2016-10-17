package com.demodb.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.demodb.BookModel;
import com.demodb.db_helper.DatabaseManager;
import com.google.auto.value.AutoValue;
import com.squareup.sqldelight.RowMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ANISH on 16-10-2016.
 */
@AutoValue
public abstract class Book implements BookModel {
    public static final Factory<Book> FACTORY = new Factory<>(AutoValue_Book::new);
    public static final RowMapper<Book> ALL_BOOK_MAPPER = FACTORY.select_all_booksMapper();
  //  public static final RowMapper<Se> SELECT_CASE_NOTES_MAPPER =
          //TODO_NOTE_FACTORY.select_all_case_NotesMapper(AutoValue_TodoNote_AllCaseNotes::new, Case.CASE_FACTORY);



    /*public static void insertInBook(String book_name, int book_price) */
    public static void insertInBook(BookRequest bookRequest)
    {

        try {
            SQLiteDatabase sqLiteDatabase = DatabaseManager.getInstance().openDatabase();
        /*sqLiteDatabase.insert(Book.TABLE_NAME, null,
                TodoNote.TODO_NOTE_FACTORY.marshal(todoNoteRequest).asContentValues());*/

            sqLiteDatabase.insert(Book.TABLE_NAME, null, Book.FACTORY.marshal()
                    .book_name(bookRequest.book_name())
                    .book_price(bookRequest.book_price())
                    .asContentValues());

            DatabaseManager.getInstance().closeDatabase();
        } catch (Exception e) {
            Log.e("INSERT_BOOK_EXP", e.toString());

        }
    }


    public static void updateInBook(BookRequest bookRequest) {
        try {
            SQLiteDatabase sqLiteDatabase = DatabaseManager.getInstance().openDatabase();

            long result = sqLiteDatabase.update(Book.TABLE_NAME, Book.FACTORY.marshal().book_name(bookRequest.book_name()).book_price(bookRequest.book_price()).asContentValues(),
                    Book.BOOK_ID +"= ?", new String[] {String.valueOf(bookRequest.book_id())});

            Log.e("UPDATE_BOOK_RES", String.valueOf(result));

            DatabaseManager.getInstance().closeDatabase();
        } catch (Exception e) {
            Log.e("UPDATE_BOOK_EXP", e.toString());

        }
    }

    public static void deleteData(BookRequest bookRequest) {
        SQLiteDatabase sqLiteDatabase = DatabaseManager.getInstance().openDatabase();
//        sqLiteDatabase.rawQuery(TodoNote.DELETE_TODO_ITEM, new String[] {String.valueOf(todoID)});
        sqLiteDatabase.delete(Book.TABLE_NAME, Book.BOOK_NAME+ "=?", new String[] {String.valueOf(bookRequest.book_name())});
        DatabaseManager.getInstance().closeDatabase();
    }

    public static List<Book> getAllBookDetails() {
        List<Book> listbooks = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = DatabaseManager.getInstance().openDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(Book.SELECT_ALL_BOOKS, new String[]{});
        if (cursor != null) {
            while (cursor.moveToNext()) {
                listbooks.add(Book.ALL_BOOK_MAPPER.map(cursor));
            }
        }
        DatabaseManager.getInstance().closeDatabase();
        return listbooks;
    }
}
/*


    public static void insertInBook(String book_name, int book_price)
    {

        try {
            SQLiteDatabase sqLiteDatabase = DatabaseManager.getInstance().openDatabase();
        */
/*sqLiteDatabase.insert(Book.TABLE_NAME, null,
                TodoNote.TODO_NOTE_FACTORY.marshal(todoNoteRequest).asContentValues());*//*


            sqLiteDatabase.insert(Book.TABLE_NAME, null, Book.FACTORY.marshal()
                    .book_name(book_name)
                    .book_price(book_price)
                    .asContentValues());

            DatabaseManager.getInstance().closeDatabase();
        } catch (Exception e) {
            Log.e("INSERT_BOOK_EXP", e.toString());

        }
    }*/
