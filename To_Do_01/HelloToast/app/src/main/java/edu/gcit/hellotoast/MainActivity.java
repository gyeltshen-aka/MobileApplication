package edu.gcit.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void DisplayToast(View view) {
        Toast B = Toast.makeText(this,"Hello Toast", Toast.LENGTH_SHORT);
        B.show();
    }

    public void changer(View view) {
        count++;
        TextView G = (TextView) findViewById(R.id.textA);
        G.setText(""+count);
    }
}