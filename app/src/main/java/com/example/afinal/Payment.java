package com.example.afinal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Date;

public class Payment extends AppCompatActivity {
    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        textView=findViewById(R.id.textview);
        imageView=findViewById(R.id.pic3);
        SharedPreferences sharedPreferences= PreferenceManager.
                getDefaultSharedPreferences(getApplicationContext());

        int yearInt=sharedPreferences.getInt("year",0);
        int amountInt=sharedPreferences.getInt("amount",0);
        float reatfloat=sharedPreferences.getFloat("rate",0);
        float decpayment=(amountInt*(1+(reatfloat*yearInt)))/(12* yearInt);
        DecimalFormat dateFormat=new  DecimalFormat("$###,###,##");
        textView.setText("pay"+dateFormat.format(decpayment));

        if(yearInt==3)
            imageView.setImageResource(R.drawable.j1);
        else if (yearInt==2) {
            imageView.setImageResource(R.drawable.j2);



        }  else if (yearInt==1)
        {
            imageView.setImageResource(R.drawable.j3);
        }
else
    textView.setText("please 1,2or3");

    }
}