package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class LuckyNumberActivity extends AppCompatActivity {

    TextView luckyNum;
    Button share;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_number);

        luckyNum = findViewById(R.id.txtNumber);
        share = findViewById(R.id.btnShare);

        Intent i = getIntent();
        String name = i.getStringExtra("name");

        String num = String.valueOf(generateLuckyNumber());

        luckyNum.setText(num);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                shareMyNumber(name,num);

            }
        });
    }

    private void shareMyNumber(String name, String num) {
        //Implicit Intent
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT,name);
        i.putExtra(Intent.EXTRA_TEXT,"Lucky Number :"+num);

        startActivity(Intent.createChooser(i,"Choose Platform to Share"));
    }

    private int generateLuckyNumber() {
        Random random = new Random();
        int upper_limit = 1000;
        return random.nextInt(upper_limit);
    }
}