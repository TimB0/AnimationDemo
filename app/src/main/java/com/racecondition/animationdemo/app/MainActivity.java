package com.racecondition.animationdemo.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;


public class MainActivity extends Activity {

    protected ImageView mRotatingImage;
    protected ImageView mSlidingImage;
    protected ImageView mScaleImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Rotate an image
        mRotatingImage = (ImageView) findViewById(R.id.rotatingImage);
        Animation rotation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        rotation.setRepeatCount(Animation.INFINITE);
        mRotatingImage.startAnimation(rotation);

        // Slide an image back and forth horizontally
        mSlidingImage = (ImageView) findViewById(R.id.slidingImage);
        Animation translation = new TranslateAnimation(0, 320,0, 0);
        translation.setDuration(1000);
        translation.setRepeatCount(Animation.INFINITE);
        translation.setRepeatMode(Animation.REVERSE);
        mSlidingImage.startAnimation(translation);

        // Zoom in and out of an image
        mScaleImage = (ImageView) findViewById(R.id.scaleImage);
        Animation resize = new ScaleAnimation(1, 2, 1, 2, 200, 50);
        resize.setDuration(2000);
        resize.setRepeatCount(Animation.INFINITE);
        resize.setRepeatMode(Animation.REVERSE);
        mScaleImage.startAnimation(resize);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
