package edu.gcit.clickable_image_implicit_intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView mDonut, mOreo, mCream, mCaller;
    String order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDonut = findViewById(R.id.donutImg);
        mOreo = findViewById(R.id.oreo);
        mCream = findViewById(R.id.cream);
        mCaller = findViewById(R.id.call);

        mDonut.setOnClickListener(v -> {
            String donut = "You have ordered Donut. Thank You!!";
            order = donut;
            Toast.makeText(this, "You have ordered Donut. Thank You!!", Toast.LENGTH_SHORT).show();
        });

        mOreo.setOnClickListener(v -> {
            String oreo = "You have ordered Oreo. Thank You!!";
            order = oreo;
            Toast.makeText(this, "You have ordered Oreo. Thank You!!", Toast.LENGTH_SHORT).show();
        });

        mCream.setOnClickListener(v -> {
            String froyo = "You have ordered Froyo Ice Cream. Thank You!!";
            order = froyo;
            Toast.makeText(this, "You have ordered Cream Ice Cream. Thank You!!", Toast.LENGTH_SHORT).show();
        });

        mCaller.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),placingOrder.class);
            intent.putExtra("order", order);
            startActivity(intent);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_order:
                Intent intent = new Intent(this, placingOrder.class);
                intent.putExtra("order", order);
                startActivity(intent);
                return true;
            case R.id.action_contact:
                Toast.makeText(this, "You selected Contacts", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_setting:
                Toast.makeText(this, "You selected Settings", Toast.LENGTH_SHORT).show();
                return true;

        }
        return true;
    }
}