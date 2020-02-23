package com.example.studentquestions;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Hashtable;

public class Questions extends AppCompatActivity {

    RadioGroup[] listOfRadioGroup = new RadioGroup[14];
    Hashtable<String, Integer> ids = new Hashtable<String, Integer>(){
     {
         put("first1", 0);
         put("second1", 1);
         put("third1", 2);

         put("first2", 1);
         put("second2", 0);
         put("third2", 2);

         put("first3", 1);
         put("second3", 0);

         put("first4", 1);
         put("second4", 0);
         put("third4", 1);

         put("first5", 2);
         put("second5", 1);
         put("third5", 0);

         put("first6", 2);
         put("second6", 0);
         put("third6", 2);

         put("first7", 2);
         put("second7", 0);
         put("third7", 1);

         put("first8", 1);
         put("second8", 0);
         put("third8", 2);

         put("first9", 1);
         put("second9", 0);
         put("third9", 2);

         put("first10", 3);
         put("second10", 1);
         put("third10", 2);
         put("forth10", 3);
         put("fifth10", 0);

         put("first11", 1);
         put("second11", 2);
         put("third11", 0);

         put("first12", 0);
         put("second12", 1);
         put("third12", 2);

         put("first13", 1);
         put("second13", 0);
         put("third13", 2);
     }

 };
    Button send;
    int count = 0;
    boolean done;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);

        send = findViewById(R.id.send);

        listOfRadioGroup[1] = findViewById(R.id.radio_group1);
        listOfRadioGroup[2] = findViewById(R.id.radio_group2);
        listOfRadioGroup[3] = findViewById(R.id.radio_group3);
        listOfRadioGroup[4] = findViewById(R.id.radio_group4);
        listOfRadioGroup[5] = findViewById(R.id.radio_group5);
        listOfRadioGroup[6] = findViewById(R.id.radio_group6);
        listOfRadioGroup[7] = findViewById(R.id.radio_group7);
        listOfRadioGroup[8] = findViewById(R.id.radio_group8);
        listOfRadioGroup[9] = findViewById(R.id.radio_group9);
        listOfRadioGroup[10] = findViewById(R.id.radio_group10);
        listOfRadioGroup[11] = findViewById(R.id.radio_group11);
        listOfRadioGroup[12] = findViewById(R.id.radio_group12);
        listOfRadioGroup[13] = findViewById(R.id.radio_group13);

        done = true;

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;

                for (int i = 1; i < 14; i++){
                    if (checkButton(v, i) == -1){
                        done = false;
                        break;
                    }else{
                        count = count + checkButton(v, i);
                        done = true;
                        //sendSMS(i);
                    }
                }
                if (done) {
                    sendSMS(count);
                }
            }
        });

    }

    public int checkButton(View view, int i) {
        try {
            int radioId =listOfRadioGroup[i].getCheckedRadioButtonId();
            RadioButton radio = findViewById(radioId);
            String id = getResources().getResourceEntryName(radioId);
            id = id.replace(" ", "");

            return ids.get(id);
        }catch (Exception e){
            Toast.makeText(this, "الرجاء الاجابة على جميع الاسئلة" , Toast.LENGTH_LONG).show();
            return -1;
        }
    }
    public void sendSMS(int c) {

        String message;
        if (c >= 20 && c <= 25){
            message  = "نتيجة الطالب هي: " + c + "\n" + "الطفل " + MainActivity.name + "يتعرض للعنف والتنمر";
        }else if (c < 10){
            message = "نتيجة الطالب هي: " + c + "\n" + "الطفل " + MainActivity.name + "لا يعاني من عنف";
        }else message = "نتيجة الطالب" + MainActivity.name + "هي :" + c + "الطالب/ة بحاجة الى المتابعة من الارشاد";
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        if (Number.n != "") {
            try {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(Number.n, null, message, null, null);
                Toast.makeText(getApplicationContext(), "تم ارسال النتيجة", Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "لم يتم ارسال النتيجة", Toast.LENGTH_LONG).show();
            }
        }else Toast.makeText(this, "الرجاء تثبيت رقم الهاتف" , Toast.LENGTH_LONG).show();
    }

}