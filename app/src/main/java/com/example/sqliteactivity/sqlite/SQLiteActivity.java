package com.example.sqliteactivity.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sqliteactivity.databinding.ActivityMainBinding;

public class SQLiteActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        setClickListeners();

    }



    private void setClickListeners() {

    }
}