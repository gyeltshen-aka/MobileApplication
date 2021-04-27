package edu.gcit.calculator_debugger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText mValue1, mValue2, mAnswer;
    Button mAddBtn, mSubBtn, mDivBtn, mMulBtn;
    public calculator mCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mValue1 = findViewById(R.id.editTextTextPersonName);
        mValue2 = findViewById(R.id.editTextTextPersonName2);
        mAddBtn = findViewById(R.id.button);
        mSubBtn = findViewById(R.id.button2);
        mDivBtn = findViewById(R.id.button3);
        mMulBtn = findViewById(R.id.button4);
        mAnswer = findViewById(R.id.editTextTextPersonName3);

        mCalculator = new calculator();
    }

    public void add(View view) {
        String value1 = mValue1.getText().toString();
        String value2 = mValue2.getText().toString();
        double result = mCalculator.add(Double.valueOf(value1),Double.valueOf(value2));
        mAnswer.setText(String.valueOf(result));
    }

    public void sub(View view) {
        String value1 = mValue1.getText().toString();
        String value2 = mValue2.getText().toString();
        double result = mCalculator.sub(Double.valueOf(value1),Double.valueOf(value2));
        mAnswer.setText(String.valueOf(result));
        Log.d("LOG_TAG","Debugging Mode");
    }

    public void div(View view) {
        String value1 = mValue1.getText().toString();
        String value2 = mValue2.getText().toString();
        double result = mCalculator.div(Double.valueOf(value1),Double.valueOf(value2));
        mAnswer.setText(String.valueOf(result));
    }

    public void multi(View view) {
        String value1 = mValue1.getText().toString();
        String value2 = mValue2.getText().toString();
        double result = mCalculator.mul(Double.valueOf(value1),Double.valueOf(value2));
        mAnswer.setText(String.valueOf(result));

    }
}