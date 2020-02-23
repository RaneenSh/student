package com.example.studentquestions;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Number extends AppCompatActivity {

    EditText number;
    public static String n;
    Button set;
    private SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.number);

        number = findViewById(R.id.p_number);
        set = findViewById(R.id.set);
        n = "";
        SharedPreferences shared = getSharedPreferences("info",MODE_PRIVATE);
        if (!number.getText().equals("")) {
            n = shared.getString("key5", n);
            number.setText(n);

        }


        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n = number.getText().toString();
                pref = getSharedPreferences("info", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("key5",n);

                editor.commit();
                Toast.makeText(getApplicationContext(), "تم تثبيت الرقم", Toast.LENGTH_LONG).show();
            }
        });

    }
}
