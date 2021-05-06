package edu.gcit.clickable_image_implicit_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class placingOrder extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    RadioButton sDay, nDay, pUp;
    TextView intentMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placing_order);

        sDay = findViewById(R.id.radio1);
        nDay = findViewById(R.id.radio2);
        pUp = findViewById(R.id.radio3);
        intentMessage = findViewById(R.id.message_intent);

        Intent obj = getIntent();
        String msg = obj.getStringExtra("order");
        intentMessage.setText(msg);

        Spinner spinner = findViewById(R.id.spinner);
        if(spinner != null){
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.layout_array, android.R.layout.simple_dropdown_item_1line);
        if(spinner != null){
            spinner.setAdapter(arrayAdapter);
        }
    }

    private void displayToast(String toastMsg) {
        Toast.makeText(getApplicationContext(),toastMsg,Toast.LENGTH_LONG).show();
    }

    public void orderType(View view) {
        boolean itemSelect = ((RadioButton)view).isChecked();

        switch(view.getId()){
            case R.id.radio1:
                displayToast("Same day messenger service");
                break;

            case R.id.radio2:
                displayToast("Same day ground delivery");
                break;

            case R.id.radio3:
                displayToast("Pick up");
                break;

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String msg = parent.getItemAtPosition(position).toString();
        displayToast(msg);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}