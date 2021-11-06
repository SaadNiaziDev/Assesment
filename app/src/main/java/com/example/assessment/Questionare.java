package com.example.assessment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;

public class Questionare extends AppCompatActivity {
    TextView name_msg,roll_msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionare);
        name_msg = (TextView)findViewById(R.id.name_display);
        roll_msg = (TextView)findViewById(R.id.roll_display);
        Intent intent = getIntent();
        String str = intent.getStringExtra("Name");
        name_msg.setText(str);
        String str2 = intent.getStringExtra("RollNum");
        roll_msg.setText(str2);
    }
}