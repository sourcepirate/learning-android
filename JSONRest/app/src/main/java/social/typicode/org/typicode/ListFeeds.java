package social.typicode.org.typicode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.view.ViewGroup;
import social.typicode.org.typicode.models.Post;
import social.typicode.org.typicode.api.UserClient;


public class ListFeeds extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle){
        View view = inflater.inflate(R.layout.list_feeds, container, false);
        new RetrivePosts(view).execute("");
        return view;
    }


    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
    }

    private class RetrivePosts extends AsyncTask<String, Void, List<Post>> {

        private Exception exception;
        private View listView;


        public RetrivePosts(View view){
            super();
            this.listView = view;
        }


        @Override
        protected List<Post> doInBackground(String... url){
            try{
                List<Post> posts = new UserClient().getAllPosts();
                return posts;
            }
            catch (IOException exp){
                return new ArrayList<Post>();
            }
        }

        @Override
        protected void onPostExecute(List<Post> result){
            ListView listView  = (ListView) this.listView.findViewById(R.id.feedList);
            FeedAdapter adapter = new FeedAdapter(getActivity(), result);
            listView.setAdapter(adapter);
        }
    }
}
