package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class EnterUserNameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_select_username);
        setContentView(R.layout.activity_select_username);

    }

    protected void setEntered() {
        EditText usernameEntry = (EditText) findViewById(R.id.usernameEditText);
        String entered = usernameEntry.getText().toString();
//        MainActivity.setUsername(entered);
        this.finish();
    }
}
