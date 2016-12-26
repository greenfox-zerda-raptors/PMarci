package com.example.myfirstapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by posam on 2016-12-23.
 */

public class MessageAdapter extends ArrayAdapter<Message> {

    MessageAdapter(Context context, ArrayList<Message> messageArrayList) {
        super(context, 0, messageArrayList);
    }
    public String convertDateString (String input) {
        String[] dateTime = input.split("T");
        String[] time = dateTime[1].split("\\.");
        return dateTime[0] + " " + time[0];
    }
    @Override
    public @Nullable Message getItem(int position) {
        return super.getItem(super.getCount() - position - 1);
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        Message message = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.messageview, parent, false);
        }
        TextView userView = (TextView) convertView.findViewById(R.id.username);
        TextView messageView = (TextView) convertView.findViewById(R.id.body);
        TextView dateView = (TextView) convertView.findViewById(R.id.created_at);
        userView.setText(message.getUsername());
        messageView.setText(message.getBody());
        dateView.setText(convertDateString(message.getCreated_at()));
        return convertView;
    }
}
