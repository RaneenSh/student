package com.example.studentquestions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button next;
    public static String name;
    EditText sName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sName = findViewById(R.id.name);
        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = sName.getText().toString();
                if (!name.equals("")) {
                    startActivity(new Intent(getApplicationContext(), Questions.class));
                }else Toast.makeText(getApplicationContext(), "الرجاء ادخال اسم الطالب", Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.settingsIcon) {
            startActivity(new Intent(getApplicationContext(), Number.class));
        }else if (id == R.id.go){
            Intent intent = getPackageManager().getLaunchIntentForPackage("com.example.danyal.bluetoothhc05");
            startActivity(intent);
        }
        return true;
    }
}
