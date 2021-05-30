package com.example.googlebooksapi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
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

        if (getSupportLoaderManager().getLoader(0) != null){
            getSupportLoaderManager().initLoader(0, null, this);
        }

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
                    Bundle queryBundle = new Bundle();
                    queryBundle.putString("queryString", queryString);
                    getSupportLoaderManager().restartLoader(0,queryBundle,MainActivity.this);

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

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
//        String queryString;
//        if (args != null){
//            queryString = args.getString("queryString");
//        }

        return new bookLoader(this,args.getString("queryString"));
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        try {
            JSONObject jsonObject = new JSONObject(data);
            JSONArray itemsArray = jsonObject.getJSONArray("items");

            int i = 0;
            String title = null;
            String authors = null;

            while (i < itemsArray.length() && (authors == null && title == null)){
                JSONObject book = itemsArray.getJSONObject(i);
                JSONObject volumeInfo = book.getJSONObject("volumeInfo");

                try {
                    title = volumeInfo.getString("title");
                    authors = volumeInfo.getString("authors");
                } catch (Exception e){
                    e.printStackTrace();
                }

                i++;
                if (title != null && authors != null){
                    mTitle.setText("Title of the Book:  " + title);
                    mAuthor.setText("Author of the book: " + authors);
                } else {
                    mTitle.setText("There is no such book available");
                    mAuthor.setText("------------------------");
                }
            }

        } catch (JSONException e){
            mTitle.setText("No book registered");
            mAuthor.setText("-----------------");
            e.printStackTrace();
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}