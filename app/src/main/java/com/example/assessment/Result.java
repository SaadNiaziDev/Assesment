package com.example.assessment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    TextView _name,_rollNum;
    Button quitButton, shareButton;
    TextView attemptedField,correctField,wrongField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        _name=findViewById(R.id.nameText);
        _rollNum=findViewById(R.id.rollText);
        quitButton=findViewById(R.id.quitButton);
        shareButton=findViewById(R.id.shareBtn);
        attemptedField=findViewById(R.id.attemptedInput);
        wrongField=findViewById(R.id.wrongInput);
        correctField=findViewById(R.id.correctInput);

        Intent GET = getIntent();
        String text1 = GET.getStringExtra("Name#");
        _name.setText(text1);
        String text2 = GET.getStringExtra("Roll#");
        _rollNum.setText(text2);
        String text3 = GET.getStringExtra("Counter++");
        attemptedField.setText(text3);
        String text4 = GET.getStringExtra("Correct++");
        correctField.setText(text4);
        String text5 = GET.getStringExtra("Wrong++");
        wrongField.setText(text5);


//        StringBuffer str = new StringBuffer();
//        str.append(Questionare.counter);
//
//        StringBuffer str2 = new StringBuffer();
//        str2.append(Questionare.correct);
//
//        StringBuffer str3 = new StringBuffer();
//        str3.append(Questionare.wrong);
//
//        attemptedField.setText(str);
//        correctField.setText(str2);
//        wrongField.setText(str3);

        Questionare.correct=0;
        Questionare.wrong=0;

        quitButton.setOnClickListener(v -> {
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        });

        shareButton.setOnClickListener(v -> {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Total Score = ");
            sendIntent.putExtra(Intent.EXTRA_TEXT,correctField.getText().toString());
            sendIntent.setType("text/plain");

            Intent shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(shareIntent);
        });
    }
}