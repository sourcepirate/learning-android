package org.todoandroid.todoandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ListView;
import java.util.List;
import java.util.ArrayList;
import android.view.View;


public class TodoActivity extends AppCompatActivity {


    private EditText textEdit;
    private Button addButton;
    private ListView lsview;
    private List<String> items;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        // initialize individual viewsi
        lsview = (ListView) findViewById(R.id.lister);
        items = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        lsview.setAdapter(adapter);
        items.add("Go to the new world");
        items.add("Find a crew");
    }

    public void onAddItem(View v){
        textEdit = (EditText) findViewById(R.id.addtext);
        String item = textEdit.getText().toString();
        adapter.add(item);
        textEdit.setText("");
    }


}
