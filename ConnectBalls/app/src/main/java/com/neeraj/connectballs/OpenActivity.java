package com.neeraj.connectballs;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class OpenActivity extends AppCompatActivity{

    Button start_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);

        start_bt = findViewById(R.id.start_bt);

        start_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OpenActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionsmenu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.rules:
                //Toast.makeText(OpenActivity.this, "Share selected", Toast.LENGTH_SHORT).show();
                DialogFragment_rules dialogFragment = new DialogFragment_rules();
                dialogFragment.show(getSupportFragmentManager(), "dialog_fragment1");
                break;
            case R.id.hints:
                //Toast.makeText(OpenActivity.this, "Rate selected", Toast.LENGTH_SHORT).show();
                DialogFragment_hints dialogFragment1 = new DialogFragment_hints();
                dialogFragment1.show(getSupportFragmentManager(), "dialog_fragment1");
                break;
        }
        return true;
    }


}
