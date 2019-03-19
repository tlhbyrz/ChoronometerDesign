package com.example.boyraztalha.choronometerdesign;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class Chonometer extends AppCompatActivity {

    ImageView img1,img2;
    Button bt,bt2;
    Animation animation,stopanim;
    Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chonometer);

        img1 = findViewById(R.id.imageView);
        img2 = findViewById(R.id.imageView2);
        bt = findViewById(R.id.button);
        bt2 = findViewById(R.id.button2);
        chronometer = findViewById(R.id.chronometer);

        bt2.setAlpha(0);
        animation = AnimationUtils.loadAnimation(this,R.anim.animch);
        stopanim = AnimationUtils.loadAnimation(this,R.anim.stopanim);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img2.setAnimation(animation);
                bt2.animate().setDuration(300).alpha(1).translationY(-52).start();
                bt2.setVisibility(View.VISIBLE);
                bt.animate().setDuration(300).alpha(0).start();
                bt.setVisibility(View.GONE);

                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img2.setAnimation(stopanim);
                bt2.animate().setDuration(300).alpha(0).translationY(52).start();
                bt.animate().setDuration(300).alpha(1).start();
                bt.setVisibility(View.VISIBLE);
                bt2.setVisibility(View.GONE);

                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.stop();
            }
        });
    }
}
