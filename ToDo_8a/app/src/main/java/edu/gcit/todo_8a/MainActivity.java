package edu.gcit.todo_8a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText openWebPage, findingLocation, sharingText;
    Button webBtn, locationBtn, sharingBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openWebPage = findViewById(R.id.editTextTextPersonName);
        findingLocation = findViewById(R.id.editTextTextPersonName2);
        sharingText = findViewById(R.id.editTextTextPersonName3);

        webBtn = findViewById(R.id.button);
        locationBtn = findViewById(R.id.button2);
        sharingBtn = findViewById(R.id.button3);

        webBtn.setOnClickListener(v -> {
            String website = openWebPage.getText().toString();
            Uri url = Uri.parse(website);
            Intent obj = new Intent(Intent.ACTION_VIEW, url);
            if (obj.resolveActivity(getPackageManager()) != null){
                Toast.makeText(this, "You have been redirected to the given website", Toast.LENGTH_SHORT).show();
                startActivity(obj);
            } else {
                Toast.makeText(this, "Error!!!" , Toast.LENGTH_SHORT).show();
            }
        });

        locationBtn.setOnClickListener(v -> {
            String location = findingLocation.getText().toString();
            Uri url = Uri.parse("geo: 0,0?q=" + location);
            Intent obj = new Intent(Intent.ACTION_VIEW, url);
            if (obj.resolveActivity(getPackageManager()) != null){
                startActivity(obj);
                Toast.makeText(this, "You have been redirected to the given website", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Error!!!" , Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        sharingBtn.setOnClickListener(v -> {
            String share =  sharingText.getText().toString();
            String mimeType =  "plain/text";
            ShareCompat.IntentBuilder
                    .from(this)
                    .setType(mimeType)
                    .setChooserTitle("Share this text with: ")
                    .setText(share)
                    .startChooser();
        });
    }
}