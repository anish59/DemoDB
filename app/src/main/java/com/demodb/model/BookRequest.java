package com.demodb.model;

import android.support.annotation.NonNull;

/**
 * Created by anish on 17-10-2016.
 */
public class BookRequest extends Book {

    private long book_id;
    private String book_name;
    private long book_price;

    public BookRequest() {
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public void setBook_price(long book_price) {
        this.book_price = book_price;
    }

    @Override
    public String toString() {
        return "Book{"
                + "book_id=" + book_id + ", "
                + "book_name=" + book_name + ", "
                + "book_price=" + book_price
                + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof Book) {
            Book that = (Book) o;
            return (this.book_id == that.book_id())
                    && (this.book_name.equals(that.book_name()))
                    && (this.book_price == that.book_price());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int h = 1;
        h *= 1000003;
        h ^= (this.book_id >>> 32) ^ this.book_id;
        h *= 1000003;
        h ^= this.book_name.hashCode();
        h *= 1000003;
        h ^= (this.book_price >>> 32) ^ this.book_price;
        return h;
    }

    @Override
    public long book_id() {
        return book_id;
    }

    @NonNull
    @Override
    public String book_name() {
        return book_name;
    }

    @Override
    public long book_price() {
        return book_price;
    }
}
