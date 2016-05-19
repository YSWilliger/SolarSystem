package com.maza.thesolarsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public ViewFlipper flipper;
    private Animation mInFromRight;
    private Animation mOutToLeft;
    private Animation mInFromLeft;
    private Animation mOutToRight;
    private ViewFlipper mViewFlipper;
    ImageButton mercButton, sunButton, astroButton, venuButton, earthButton, marsButton, jupButton,
            satButton, uraButton, neptButton, dwarfButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mercButton = (ImageButton) findViewById(R.id.mercButton);
        sunButton = (ImageButton) findViewById(R.id.sunButton);
        venuButton = (ImageButton) findViewById(R.id.venuButton);
        earthButton = (ImageButton) findViewById(R.id.earthButton);
        marsButton = (ImageButton) findViewById(R.id.marsButton);
        astroButton = (ImageButton) findViewById(R.id.asterButton);
        jupButton = (ImageButton) findViewById(R.id.jupButton);
       satButton = (ImageButton) findViewById(R.id.satButton);
        uraButton = (ImageButton) findViewById(R.id.uraButton);
        neptButton = (ImageButton) findViewById(R.id.nepButton);
        dwarfButton = (ImageButton) findViewById(R.id.dwarfButton);

        sunButton.setTag("1");
        mercButton.setTag("2");
        venuButton.setTag("3");
        earthButton.setTag("4");
        marsButton.setTag("5");
        astroButton.setTag("6");
        jupButton.setTag("7");
        satButton.setTag("8");
        uraButton.setTag("9");
        neptButton.setTag("10");
        dwarfButton.setTag("11");

        mercButton.setOnClickListener(this);
        sunButton.setOnClickListener(this);
        venuButton.setOnClickListener(this);
        earthButton.setOnClickListener(this);
        marsButton.setOnClickListener(this);
        astroButton.setOnClickListener(this);
        jupButton.setOnClickListener(this);
        satButton.setOnClickListener(this);
        uraButton.setOnClickListener(this);
        neptButton.setOnClickListener(this);
        dwarfButton.setOnClickListener(this);;


        flipper = (ViewFlipper) findViewById(R.id.view_flipper);
        ImageButton toRight = (ImageButton) findViewById(R.id.toRightButton);
        ImageButton toLeft = (ImageButton) findViewById(R.id.toLeftButton);

        toRight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                flipper.setInAnimation(inFromRightAnimation());
                flipper.setOutAnimation(outToLeftAnimation());
                flipper.showNext();
            }
        });

        toLeft.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                flipper.setInAnimation(inFromLeftAnimation());
                flipper.setOutAnimation(outToRightAnimation());
                flipper.showPrevious();
            }
        });

    }


    private Animation inFromRightAnimation() {
        Animation inFromRight = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT,  +1.0f, Animation.RELATIVE_TO_PARENT,  0.0f,
                Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,   0.0f
        );
        inFromRight.setDuration(500);
        inFromRight.setInterpolator(new AccelerateInterpolator());
        return inFromRight;
    }
    private Animation outToLeftAnimation() {
        Animation outtoLeft = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,  -1.0f,
                Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,   0.0f
        );
        outtoLeft.setDuration(500);
        outtoLeft.setInterpolator(new AccelerateInterpolator());
        return outtoLeft;
    }

    private Animation inFromLeftAnimation() {
        Animation inFromLeft = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT,  -1.0f, Animation.RELATIVE_TO_PARENT,  0.0f,
                Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,   0.0f
        );
        inFromLeft.setDuration(500);
        inFromLeft.setInterpolator(new AccelerateInterpolator());
        return inFromLeft;
    }
    private Animation outToRightAnimation() {
        Animation outtoRight = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,  +1.0f,
                Animation.RELATIVE_TO_PARENT,  0.0f, Animation.RELATIVE_TO_PARENT,   0.0f
        );
        outtoRight.setDuration(500);
        outtoRight.setInterpolator(new AccelerateInterpolator());
        return outtoRight;
    }

    @Override
    public void onClick(View v) {
        String tag= v.getTag().toString();
        Log.i("Button ID", tag);
        Intent i = new Intent(getApplicationContext(), PlanetDataActivity.class);
        i.putExtra("button name", tag);
        startActivity(i);
    }
}
