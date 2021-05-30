package com.example.googlebooksapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView mDes, mTitle, mAuthor;
    EditText mInputTitle;
    Button mBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDes = findViewById(R.id.textView);
        mTitle = findViewById(R.id.title);
        mAuthor = findViewById(R.id.author);
        mInputTitle = findViewById(R.id.editText);
        mBtn = findViewById(R.id.button);

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String queryString = mInputTitle.getText().toString();
                new fetchBook(mTitle, mAuthor).execute(queryString);

                ConnectivityManager connectivityManager = (ConnectivityManager)
                        getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = null;
                if (connectivityManager != null){
                    networkInfo = connectivityManager.getActiveNetworkInfo();
                }

                if (networkInfo != null && networkInfo.isConnected() && queryString.length() != 0){
                    new fetchBook(mTitle, mAuthor).execute(queryString);
                    mAuthor.setText("------------------------");
                    mTitle.setText(R.string.loading);
                } else {
                    if (queryString.length() == 0){
                        mAuthor.setText("------------------------");
                        mTitle.setText(R.string.noSearch);
                    } else {
                        mAuthor.setText("------------------------");
                        mTitle.setText(R.string.noNetwork);
                    }
                }
            }
        });

    }
}