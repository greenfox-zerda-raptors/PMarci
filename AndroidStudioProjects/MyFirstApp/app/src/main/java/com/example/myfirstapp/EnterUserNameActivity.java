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
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class EnterUserNameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_select_username);
        setContentView(R.layout.activity_select_username);
        EditText editText = (EditText) findViewById(R.id.usernameEditText);
        TextView.OnEditorActionListener enterListener = new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    setEntered(findViewById(R.id.usernameEditText));
                }
                return true;
            }
        };
        editText.setOnEditorActionListener(enterListener);

    }

    protected void setEntered(View view) {
        EditText usernameEntry = (EditText) findViewById(R.id.usernameEditText);
        String entered = usernameEntry.getText().toString();
        MainActivity.username = entered;
        SharedPreferences sharedPreferences = MainActivity.sharedPreferences;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getString(R.string.username), entered);
        editor.commit();
        MenuItem preview = MainActivity.menu.findItem(R.id.usernamePreview);
        preview.setTitle(entered);
        this.finish();
    }
}
