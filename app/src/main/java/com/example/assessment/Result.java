package com.example.assessment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
        Intent GET = getIntent();
        String text1 = GET.getStringExtra("Name");
        _name.setText(text1);
        String text2 = GET.getStringExtra("Roll#");
        _rollNum.setText(text2);

        quitButton=(Button)findViewById(R.id.quitButton);
        shareButton=(Button) findViewById(R.id.shareBtn);
        attemptedField=(TextView) findViewById(R.id.attemptedInput);
        wrongField=(TextView) findViewById(R.id.wrongInput);
        correctField=(TextView) findViewById(R.id.correctInput);

        StringBuffer str = new StringBuffer();
        str.append(Questionare.counter);

        StringBuffer str2 = new StringBuffer();
        str2.append(Questionare.correct);

        StringBuffer str3 = new StringBuffer();
        str3.append(Questionare.wrong);

        attemptedField.setText(str);
        correctField.setText(str2);
        wrongField.setText(str3);

        Questionare.correct=0;
        Questionare.wrong=0;

        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Total Score = ");
                sendIntent.putExtra(Intent.EXTRA_TEXT,correctField.getText().toString());
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });
    }
}