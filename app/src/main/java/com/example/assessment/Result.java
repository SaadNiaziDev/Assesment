package com.example.assessment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    Button quitButton, shareButton;
    TextView attemptedField,correctField,wrongField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        quitButton=(Button)findViewById(R.id.quitButton);
        shareButton=(Button) findViewById(R.id.shareBtn);
        attemptedField=(TextView) findViewById(R.id.attemptedInput);
        wrongField=(TextView) findViewById(R.id.wrongInput);
        correctField=(TextView) findViewById(R.id.correctInput);

    }
}