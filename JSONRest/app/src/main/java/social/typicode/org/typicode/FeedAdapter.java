package social.typicode.org.typicode;

import java.util.List;
import social.typicode.org.typicode.models.Post;

import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by plasmashadow on 2/18/18.
 */

public class FeedAdapter extends ArrayAdapter<Post> {

    private Activity context;
    private List<Post> posts;

    public FeedAdapter(Activity context, List<Post> posts){
        super(context, R.layout.list_feeds, posts);
        this.context = context;
        this.posts = posts;
    }

    public View getView(int position, View view, ViewGroup container){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.feed_row_layout, null, true);
        TextView title = (TextView) rowView.findViewById(R.id.title);
        TextView body = (TextView) rowView.findViewById(R.id.body);
        Post post = posts.get(position);
        title.setText(post.getTitle());
        body.setText(post.getBody());
        return rowView;
    }


}
