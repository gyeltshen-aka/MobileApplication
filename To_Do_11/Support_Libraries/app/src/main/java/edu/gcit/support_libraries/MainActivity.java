package edu.gcit.support_libraries;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public String mColor[] = {"purple_200","purple_500","purple_700","teal_200","teal_700","black","lime","yellow"};
    TextView mTextView;
    Button mChangeColorBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.helloWorld);
        mChangeColorBtn = findViewById(R.id.colorChanger);

        mChangeColorBtn.setOnClickListener(v -> {
            Random rand = new Random();
            String colorName = mColor[rand.nextInt(16)];

            int colorResource = getResources().getIdentifier(colorName,"color",getApplicationContext().getPackageName());

            int colorRes = ContextCompat.getColor(this,colorResource);
            mTextView.setTextColor(colorRes);
        });

    }

//    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//
//        outState.putInt("color", mTextView.getCurrentHintTextColor());
//    }

}