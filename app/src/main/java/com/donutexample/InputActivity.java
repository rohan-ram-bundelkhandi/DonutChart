package com.donutexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {

    private EditText totalEditText;
    private EditText correctEditText;
    private EditText incorrectEditText;
    private EditText unAttempedEditText;
    private Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        totalEditText = (EditText) findViewById(R.id.total);
        correctEditText = (EditText) findViewById(R.id.correct);
        incorrectEditText = (EditText) findViewById(R.id.incorrect);
        unAttempedEditText = (EditText) findViewById(R.id.unAttempted);
        submitButton = (Button) findViewById(R.id.submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int totalCnt = Integer.parseInt(totalEditText.getText().toString());
                int correctCnt = Integer.parseInt(correctEditText.getText().toString());
                int incorrectCnt = Integer.parseInt(incorrectEditText.getText().toString());
                int unAttemptedCnt = Integer.parseInt(unAttempedEditText.getText().toString());

                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra("totalCnt",totalCnt);
                i.putExtra("correctCnt",correctCnt);
                i.putExtra("incorrectCnt",incorrectCnt);
                i.putExtra("unAttemptedCnt",unAttemptedCnt);
                startActivity(i);
                finish();
            }
        });


    }
}
