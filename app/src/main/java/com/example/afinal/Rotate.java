package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Rotate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate);
        ImageView pic2=findViewById(R.id.pic2);
        pic2.startAnimation(AnimationUtils.loadAnimation(this,R.anim.rotate));
    }
}