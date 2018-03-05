package org.blacknights.dummybooks.adapters;

import org.blacknights.dummybooks.R;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import org.blacknights.dummybooks.models.Book;
import org.blacknights.dummybooks.holders.BookHolder;

/**
 * Created by plasmashadow on 3/5/18.
 */

public class BookAdapter extends RecyclerView.Adapter<BookHolder>{

    private List<Book> bookList;

    public BookAdapter(List<Book> books){
        this.bookList = books;
    }

    @Override
    public BookHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_row, parent, false);
        return new BookHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BookHolder holder, int position){
        Book book = this.bookList.get(position);
        holder.setTag(book.getTag());
        holder.setTitle(book.getName());
    }

    @Override
    public int getItemCount(){
        return bookList.size();
    }

}
