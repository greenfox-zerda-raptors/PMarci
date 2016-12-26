package com.example.myfirstapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public ArrayList<Message> myMessageArray = new ArrayList<>();
    public ListView listView;
    public ArrayAdapter<Message> adapter;
    ServiceInterface service;
    public static Menu menu;
    static SharedPreferences sharedPreferences;
    public static String username;

    final Runnable r = new Runnable() {
        @Override
        public void run() {
            getMessage(service);
            listView.postDelayed(this, 1000);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MainActivity.menu = menu;
        MenuItem preview = MainActivity.menu.findItem(R.id.usernamePreview);
        preview.setTitle(username);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
        MainActivity.username = sharedPreferences.getString(getString(R.string.username), "default");
        setContentView(R.layout.activity_main);
        adapter = new MessageAdapter(this, myMessageArray);
        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://zerda-raptor.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        service = retrofit.create(ServiceInterface.class);
        getMessage(service);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        TextView.OnEditorActionListener enterListener = new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    addToList(findViewById(R.id.edit_message));
                }
                    return true;
            }
        };
        editText.setOnEditorActionListener(enterListener);
    }

    @Override
    public void onPause() {
        super.onPause();
        listView.removeCallbacks(r);
    }
    @Override
    public void onResume() {
        super.onResume();
        listView.postDelayed(r, 1000);
    }
    public void setUsername(MenuItem menuItem) {
        Intent intent = new Intent(this, EnterUserNameActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);

        startActivity(intent);
    }


    public void addToList(View view) {
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String text = editText.getText().toString();
        Message message = new Message(text, username);
        service.postMessageCall(new MessageWrapper(message)).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
        getMessage(service);
        editText.setText("");
    }

    public void getMessage(ServiceInterface service) {
        service.getMessageCall().enqueue(new Callback<List<Message>>() {
            @Override
            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
                if (response.isSuccessful()) {
                    adapter.clear();
                    adapter.addAll(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {

            }
        });
    }



}
