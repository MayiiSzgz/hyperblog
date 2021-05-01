package com.example.sqliteactivity.sqlite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.sqliteactivity.R;
import com.example.sqliteactivity.databinding.ActivitySQLiteBinding;

public class SQLiteActivity extends AppCompatActivity {
    ActivitySQLiteBinding activitySQLiteBinding;

    @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySQLiteBinding = ActivitySQLiteBinding.inflate((getLayoutInflater()));
        setContentView(activitySQLiteBinding.getRoot());
        setClickListeners();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menu_nuevo:
            startActivity(new Intent(getApplicationContext(), AgregandoDatosActivity.class));
            return true;

            case R.id.prueba:
                Toast.makeText(getApplicationContext(), "holaaaaa", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setClickListeners() {
    }




}