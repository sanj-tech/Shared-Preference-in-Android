package com.jsstech.sharedpreferencedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button storeinformation, showinformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        storeinformation = (Button) findViewById(R.id.btn_store_info);
        showinformation = (Button) findViewById(R.id.btn_show_info);
        textView = (TextView) findViewById(R.id.textView);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_store_info:
                        Intent intent = new Intent(MainActivity.this, prefer.class);
                        startActivity(intent);
                        break;
                    case R.id.btn_show_info:
                        displaySharedPreferences();
                        break;
                    default:
                        break;
                }
            }

    };
        storeinformation.setOnClickListener(listener);
        showinformation.setOnClickListener(listener);
}

    private void displaySharedPreferences() {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        String username = prefs.getString("username", "Default Name");
        String passw = prefs.getString("password", "Default Password");
        boolean checkBox = prefs.getBoolean("checkBox", false);
        String listPrefs = prefs.getString("listpref", "Default list Items");


        StringBuilder builder = new StringBuilder();
        builder.append("Username: " + username + "\n");
        builder.append("Password: " + passw + "\n");
        builder.append("Keep me logged in: " + String.valueOf(checkBox) + "\n");
        builder.append("List preference: " + listPrefs);
        textView.setText(builder.toString());

    }
    }