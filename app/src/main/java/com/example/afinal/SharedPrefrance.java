package com.example.afinal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SharedPrefrance extends AppCompatActivity {
    EditText year,rate,amount;
    Button payment;
    int year_int,amount_int;
    float rate_float;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_prefrance);
        year=findViewById(R.id.year);
        rate=findViewById(R.id.rate);
        amount=findViewById(R.id.amount);
        payment=findViewById(R.id.payment);
        SharedPreferences sharedPref =  PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 year_int=Integer.parseInt(year.getText().toString());
               amount_int=Integer.parseInt(amount.getText().toString());
               rate_float=Float.parseFloat(rate.getText().toString());
                SharedPreferences .Editor editor=sharedPref.edit();
                editor.putInt("year",year_int);
                editor.putInt("amount",amount_int);
                editor.putFloat("rate",rate_float);
                editor.commit();
                AlertDialog.Builder builder=new AlertDialog.Builder(SharedPrefrance.this);
                builder.setTitle("shared");
                builder.setCancelable(true);
                builder.setMessage("year" +sharedPref.getInt("year",0)+"\n amount"+sharedPref.getInt("amount",1));
                builder.show();
               // startActivity(new Intent(SharedPrefrance.this,Payment.class));

            }
        });


    }
}