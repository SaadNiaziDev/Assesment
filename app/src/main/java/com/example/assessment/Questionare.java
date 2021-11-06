package com.example.assessment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

public class Questionare extends AppCompatActivity {
    TextView questionBox;
    RadioGroup radioGroup;
    RadioButton r1,r2,r3,r4;
    String questions[] = {"Which method can be defined only once in a program?",
            "Which of these is not a bitwise operator?",
            "Which keyword is used by method to refer to the object that invoked it?",
            "Which of these keywords is used to define interfaces in Java?",
            "Which of these access specifiers can be used for an interface?",
            "Which of the following is correct way of importing an entire package ‘pkg’?",
            "What is the return type of Constructors?",
            "Which of the following package stores all the standard java classes?",
            "Which of these method of class String is used to compare two String objects for their equality?",
            "An expression involving byte, int, & literal numbers is promoted to which of these?",
    };
    String anwsers[]={"main method","<=","this","interface","public","import pkg.*","None of the mentioned","java","equals()","int"
    };
    String options[]={"finalize method","main method","static method","private method",
            "&","&=","|=","<=",
            "import","this","catch","abstract",
            "Interface","interface","intf","Intf",
            "public","protected","private","All of the mentioned",
            "Import pkg.","import pkg.*","Import pkg.*","import pkg.",
            "int","float","void","None of the mentioned",
            "lang","java","util","java.packages",
            "equals()","Equals()","isequal()","Isequal()",
            "int","long","byte","float"
    };
    public static int marks=0,correct=0,wrong=0;
    TextView name_msg,roll_msg;
    int counter=0;
    Button submitBtn,quitBtn;

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

        questionBox=(TextView)findViewById(R.id.questionBox);
        submitBtn=(Button)findViewById(R.id.submitBtn);
        quitBtn=(Button)findViewById(R.id.quitBtn);
        questionBox.setText(questions[0]);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        r1=(RadioButton)findViewById(R.id.radioButton);
        r2=(RadioButton)findViewById(R.id.radioButton2);
        r3=(RadioButton)findViewById(R.id.radioButton3);
        r4=(RadioButton)findViewById(R.id.radioButton4);
        r1.setText(options[0]);
        r2.setText(options[1]);
        r3.setText(options[2]);
        r4.setText(options[3]);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

        if(radioGroup.getCheckedRadioButtonId()==-1){
            Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton userAnwser = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
        String anwserText = userAnwser.getText().toString();

        if(anwserText.equals(anwsers[counter])){
            correct++;
        }else {
            wrong++;
        }
        counter++;

        if(counter<questions.length)
        {
            questionBox.setText(questions[counter]);
            r1.setText(options[counter*4]);
            r2.setText(options[counter*4 +1]);
            r3.setText(options[counter*4 +2]);
            r4.setText(options[counter*4 +3]);
        }
        else
        {
            marks=correct;
            Intent in = new Intent(getApplicationContext(),Result.class);
            startActivity(in);
        }
        radioGroup.clearCheck();
        }
    });

        quitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Result.class);
                startActivity(intent);
            }
        });
}
}