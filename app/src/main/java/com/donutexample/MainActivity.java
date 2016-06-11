package com.donutexample;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView totalTextView;
    private TextView correctTextView;
    private TextView incorrectTextView;
    private TextView unAttemptedTextView;
    private TextView scoreTextView;
    private TextView performanceMsg;

    public static int correctAngle;
    public static int incorrectAngle;
    public static int unAttemptedAngle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalTextView = (TextView) findViewById(R.id.total);
        correctTextView = (TextView) findViewById(R.id.correct);
        incorrectTextView = (TextView) findViewById(R.id.incorrect);
        unAttemptedTextView = (TextView) findViewById(R.id.unAttempted);
        scoreTextView = (TextView) findViewById(R.id.percentageScore);
        performanceMsg = (TextView) findViewById(R.id.performanceMsg);

        Bundle bundle=getIntent().getExtras();

        int totalCnt = Integer.parseInt(""+bundle.get("totalCnt"));
        int correctCnt = Integer.parseInt(""+bundle.get("correctCnt"));
        int incorrectCnt = Integer.parseInt(""+bundle.get("incorrectCnt"));
        int unAttemptedCnt = Integer.parseInt(""+bundle.get("unAttemptedCnt"));

        totalTextView.setText("Total Questions :"+totalCnt);
        correctTextView.setText("Correct Answers :"+correctCnt);
        incorrectTextView.setText("Incorrect Answers :"+incorrectCnt);
        unAttemptedTextView.setText("Un-Attempted Questions :"+unAttemptedCnt);

        correctAngle = (360*correctCnt)/totalCnt;
        incorrectAngle = (360*incorrectCnt)/totalCnt;
        unAttemptedAngle = (360*unAttemptedCnt)/totalCnt;

        int score=(100*correctCnt)/(totalCnt-unAttemptedCnt);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE); // the results will be higher than using the activity context object or the getWindowManager() shortcut
        wm.getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;

        if(screenWidth>=720){
            scoreTextView.setTextSize(25);
        }
        else if(screenWidth>=480 && screenWidth<720){
            scoreTextView.setTextSize(20);
        }



        scoreTextView.setText(""+score+" %");

        if(score>=90){
            performanceMsg.setText("Your Performance is Excellent");
        }else if(score<90 && score>=70){
            performanceMsg.setText("Your Performance is Good");
        }else if(score<70 && score>=50){
            performanceMsg.setText("Your Performance is Average");
        }else{
            performanceMsg.setText("Your Performance is Bad");
        }
    }
}
