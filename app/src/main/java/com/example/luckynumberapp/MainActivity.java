package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edit_name;
    Button generateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_name = findViewById(R.id.edt_uname);
        generateBtn = findViewById(R.id.btnGenerate);

        generateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = edit_name.getText().toString();

                //Explicit Intent
                Intent i = new Intent(MainActivity.this,LuckyNumberActivity.class);
                i.putExtra("name",uname);
                startActivity(i);
            }
        });
    }
}