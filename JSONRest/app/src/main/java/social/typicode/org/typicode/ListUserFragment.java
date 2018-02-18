package social.typicode.org.typicode;

import android.support.v4.app.Fragment;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import social.typicode.org.typicode.api.UserClient;
import social.typicode.org.typicode.models.User;

/**
 * Created by plasmashadow on 2/16/18.
 */

public class ListUserFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.list_users, container, false);
        new RetriveUsers(view).execute("");
        return view;
    }

    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
    }

    private class RetriveUsers extends AsyncTask<String, Void, List<User>> {

        private Exception exception;
        private View listView;

        public RetriveUsers(View view){
            super();
            this.listView = view;
        }

        @Override
        protected List<User> doInBackground(String... urls){
            try{
                List<User> users = new UserClient().getAllUsers();
                return users;
            } catch(IOException e){
                return new ArrayList<User>();
            }
        }

        @Override
        protected void onPostExecute(List<User> result){
            ListView view = (ListView) this.listView.findViewById(R.id.users);
            ArrayAdapter<User> adapter =  new ArrayAdapter<User>(getContext(), android.R.layout.simple_list_item_1, result);
            view.setAdapter(adapter);
        }
    }
}
