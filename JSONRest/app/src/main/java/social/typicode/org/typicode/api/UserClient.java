package social.typicode.org.typicode.api;

import java.util.List;
import java.util.ArrayList;

import social.typicode.org.typicode.models.Post;
import social.typicode.org.typicode.models.User;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import android.util.Log;
/**
 * Created by plasmashadow on 2/15/18.
 */

public class UserClient {

    private OkHttpClient client;

    public UserClient(){
        this.client = new OkHttpClient();
    }

    public List<User> getAllUsers() throws IOException {
        Request request = new Request.Builder().url("http://jsonplaceholder.typicode.com/users").build();
        Type listType = new TypeToken<ArrayList<User>>(){}.getType();
        try(Response response = this.client.newCall(request).execute()) {
            String value = response.body().string();
            Log.v("Users", value);
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            List<User> users = gson.fromJson(value, listType);
            return users;
        }
    }

    public List<Post> getAllPosts() throws IOException {
        Request request = new Request.Builder().url("http://jsonplaceholder.typicode.com/posts").build();
        Type listType = new TypeToken<ArrayList<Post>>(){}.getType();
        try(Response response = this.client.newCall(request).execute()) {
            String value = response.body().string();
            Log.v("Feeds", value);
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            List<Post> posts = gson.fromJson(value, listType);
            return posts;
        }
    }
}

