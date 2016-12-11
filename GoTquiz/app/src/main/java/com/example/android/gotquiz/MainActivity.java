package com.example.android.gotquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*
    Generated the score
     */
    public void genScore(View view) {
        int score = 0;

        RadioGroup radioGroupOne = (RadioGroup)findViewById(R.id.radio_one);
        int checkedRadioButtonId = radioGroupOne.getCheckedRadioButtonId();
        if (checkedRadioButtonId == R.id.oneOptionThree) {
            score++;
        }

        boolean isCheckedFirst = ((CheckBox) findViewById(R.id.twoOptionOne)).isChecked();
        boolean isCheckedSecond = ((CheckBox) findViewById(R.id.twoOptionTwo)).isChecked();
        boolean isCheckedThird = ((CheckBox) findViewById(R.id.twoOptionThree)).isChecked();
        boolean isCheckedFourth = ((CheckBox) findViewById(R.id.twoOptionFour)).isChecked();
        if ((isCheckedFirst && isCheckedSecond && isCheckedThird) && (!isCheckedFourth)) {
            score++;
        }

        RadioGroup radioGroupThree = (RadioGroup)findViewById(R.id.radio_three);
        int checkedRadioButtonThree = radioGroupThree.getCheckedRadioButtonId();
        if (checkedRadioButtonThree == R.id.threeOptionFour) {
            score++;
        }

        RadioGroup radioGroupFour = (RadioGroup)findViewById(R.id.radio_four);
        int checkedRadioButtonFour = radioGroupFour.getCheckedRadioButtonId();
        if (checkedRadioButtonFour == R.id.fourOptionThree) {
            score++;
        }

        RadioGroup radioGroupFive = (RadioGroup)findViewById(R.id.radio_five);
        int checkedRadioButtonFive = radioGroupFive.getCheckedRadioButtonId();
        if (checkedRadioButtonFive == R.id.fiveOptionOne) {
            score++;
        }

        RadioGroup radioGroupSix = (RadioGroup)findViewById(R.id.radio_six);
        int checkedRadioButtonSix = radioGroupSix.getCheckedRadioButtonId();
        if (checkedRadioButtonSix == R.id.sixOptionThree) {
            score++;
        }

        EditText seventhAnswer = (EditText) findViewById(R.id.textAnswer);
        if (seventhAnswer.getText().toString().equals("a ladder")) {
            score++;
        }

        displayScore(score);
    }

    /*
    Display the score as a toast
     */
    public void displayScore(int score) {
        int numberOfQuestions = 7;
        if (score > 4) {
            Toast.makeText(MainActivity.this, "Well done!" + " You scored " + score + " out of " + numberOfQuestions + "!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(MainActivity.this, "You scored " + score + " out of " + numberOfQuestions + ".", Toast.LENGTH_SHORT).show();
        }
    }
}
