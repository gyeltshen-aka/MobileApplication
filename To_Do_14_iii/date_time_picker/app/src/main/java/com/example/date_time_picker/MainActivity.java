package com.example.date_time_picker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button mDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDate = findViewById(R.id.date);

        mDate.setOnClickListener(v -> {
            DialogFragment newFragment = new datePicker_fragment();
            newFragment.show(getSupportFragmentManager(), "datePicker");
        });
    }

    public void processDatePickerResult(int year, int month, int dayOfMonth) {
        String month_string = Integer.toString(month +1);
        String day_string = Integer.toString(dayOfMonth);
        String year_string = Integer.toString(year);

        String date_message = (month_string + "/" + day_string + "/" + year_string);

        Toast.makeText(this, "Date" + date_message, Toast.LENGTH_SHORT).show();
    }
}