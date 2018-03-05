package org.blacknights.dummybooks.holders;

import org.blacknights.dummybooks.R;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by plasmashadow on 3/5/18.
 */

public class BookHolder extends RecyclerView.ViewHolder {

    private TextView title;
    private TextView tag;

    public BookHolder(View view) {
        super(view);
        title = (TextView) view.findViewById(R.id.title);
        tag = (TextView) view.findViewById(R.id.tag);
    }

    public void setTitle(String title){
        this.title.setText(title);
    }

    public void setTag(String tag){
        this.tag.setText(tag);
    }
}
