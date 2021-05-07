package com.example.contextual_menu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button mAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAlert = findViewById(R.id.alert);

        mAlert.setOnClickListener(v -> {
            AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(MainActivity.this);
            myAlertBuilder.setTitle("Alert");
            myAlertBuilder.setMessage("Click OK to continue or Cancel to stop");

            myAlertBuilder.setPositiveButton("Ok", (dialog, which) -> {
                Toast.makeText(getApplicationContext(), "Pressed Ok", Toast.LENGTH_SHORT).show();
            });

            myAlertBuilder.setNegativeButton("Cancel", (dialog, which) -> {
                Toast.makeText(getApplicationContext(), "Pressed Cancel", Toast.LENGTH_SHORT).show();
            });

            myAlertBuilder.show();
        });



    }
}