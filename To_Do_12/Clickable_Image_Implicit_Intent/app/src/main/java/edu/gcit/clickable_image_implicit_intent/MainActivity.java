package edu.gcit.clickable_image_implicit_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView mDonut, mOreo, mCream, mCaller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDonut = findViewById(R.id.donutImg);
        mOreo = findViewById(R.id.oreo);
        mCream = findViewById(R.id.cream);
        mCaller = findViewById(R.id.call);

        mDonut.setOnClickListener(v -> {
            Toast.makeText(this, "You have ordered Donut. Thank You!!", Toast.LENGTH_SHORT).show();
        });

        mOreo.setOnClickListener(v -> {
            Toast.makeText(this, "You have ordered Oreo. Thank You!!", Toast.LENGTH_SHORT).show();
        });

        mCream.setOnClickListener(v -> {
            Toast.makeText(this, "You have ordered Cream Ice Cream. Thank You!!", Toast.LENGTH_SHORT).show();
        });

        mCaller.setOnClickListener(v -> {
            String number = "17499118";
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" +number));
            startActivity(intent);
        });
    }
}