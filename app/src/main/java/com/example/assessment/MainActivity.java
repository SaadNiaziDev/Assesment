package com.example.assessment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button ProceedBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ProceedBtn = findViewById(R.id.proceedBtn);
        EditText name = findViewById(R.id.nameInput);
        EditText rollNum = findViewById(R.id.rollNumberInput);
        ProceedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data1 = name.getText().toString();
                String data2 = rollNum.getText().toString();
                Intent nextScreen = new Intent(getApplicationContext(),Questionare.class);
                nextScreen.putExtra("Name", data1);
                nextScreen.putExtra("RollNum",data2);
                startActivity(nextScreen);
            }
        });
    }
}