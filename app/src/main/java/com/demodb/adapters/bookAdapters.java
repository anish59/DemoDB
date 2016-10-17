package com.demodb.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demodb.R;
import com.demodb.model.Book;

import java.util.List;

/**
 * Created by anish on 17-10-2016.
 */
public class bookAdapters extends RecyclerView.Adapter<bookAdapters.bookViewHolder>
{
    Context context;
    List<Book> items;

    public bookAdapters(Context context, List<Book> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public bookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.bookrow,parent,false);
        return new bookViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(bookViewHolder holder, int position)
    {
       /*// Book_pojo book_pojo=items.get(position);*/

        holder.name.setText(items.get(position).book_name());
        holder.price.setText(items.get(position).book_price()+"");
        holder.id.setText(items.get(position).book_id()+"");
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    static class bookViewHolder extends RecyclerView.ViewHolder {

        public TextView id, name, price;

        public bookViewHolder(View itemView) {
            super(itemView);
            id=(TextView)itemView.findViewById(R.id.book_row_id);
            name=(TextView)itemView.findViewById(R.id.book_row_name);
            price=(TextView)itemView.findViewById(R.id.book_row_price);
        }
    }
}
