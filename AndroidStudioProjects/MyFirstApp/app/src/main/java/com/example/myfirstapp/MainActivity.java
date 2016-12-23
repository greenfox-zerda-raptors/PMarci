package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public ArrayList<Message> myStringArray = new ArrayList<>();
    public ListView listView;
    public ArrayAdapter<Message> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new MessageAdapter(this, myStringArray);
        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void addToList(View view) {
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String text = editText.getText().toString();
        Message message = new Message(text, "DEFAULT");
        adapter.add(message);
    }
}
