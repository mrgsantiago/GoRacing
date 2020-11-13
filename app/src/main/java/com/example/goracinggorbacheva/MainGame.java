package com.example.goracinggorbacheva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.concurrent.TimeUnit;

public class MainGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        ImageView userCar = (ImageView) findViewById(R.id.imageView3);
        ImageView carPC = (ImageView) findViewById(R.id.imageView4);
        Button drive_btn = (Button) findViewById(R.id.button2);
        Button start_btn = (Button) findViewById(R.id.button);
        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float translationX = carPC.getTranslationX();
                float translationY = carPC.getTranslationY();
                TranslateAnimation animation = new TranslateAnimation(translationX, translationX+2600, translationY,translationX);
                animation.setDuration(TimeUnit.SECONDS.toMillis(3L));
                animation.setFillAfter(true);
                carPC.startAnimation(animation);
            }
        });

        drive_btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                float translationX = userCar.getTranslationX();
                float translationY = userCar.getTranslationY();
                TranslateAnimation animation = new TranslateAnimation(translationX, translationX+2600, translationY,translationX);
                animation.setDuration(TimeUnit.SECONDS.toMillis(2L));
                animation.setFillAfter(true);
                userCar.startAnimation(animation);

                return false;
            }
        });
    }
}