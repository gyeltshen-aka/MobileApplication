package com.example.asynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void, Void, String> {
    //weakReference solves the second drawback of the Async Task
    private WeakReference<TextView> mTextView;   //< > means generic which can take any data type.

    public SimpleAsyncTask(TextView tv){
        mTextView = new WeakReference<>(tv);
    }
    @Override
    protected String doInBackground(Void... voids) {
        Random r = new Random();
        int n = r.nextInt(11);
        int s = n * 200; // generates random number to let your app sleep
        try {
            Thread.sleep(s); // method in the thread class which sleeps your app for certain second(s in this case)
        }
        catch (InterruptedException e){
            e.printStackTrace(); //generates exception
        }

        return "Awake at last after sleeping for "+ s + " milliseconds";
    }

    @Override
    protected void onPostExecute(String s) { //take the parameter that is returend from doInBackground has finished executing.
        mTextView.get().setText(s);
    }
}
