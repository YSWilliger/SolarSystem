package com.maza.thesolarsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.maza.thesolarsystem.R;

public class PlanetDataActivity extends AppCompatActivity {

    TextView plData;
    ImageView plImage;
    String buttonTag;
    Button nextPlButton;
    String[] planet_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_data);


        plData = (TextView) findViewById(R.id.plData);
        plData.setMovementMethod(new ScrollingMovementMethod());
        plImage = (ImageView) findViewById(R.id.plImage);
        nextPlButton = (Button) findViewById(R.id.nextPlButton);

        planet_data = getResources().getStringArray(R.array.planet_data);

        Intent i = getIntent();
        buttonTag = i.getStringExtra("button name");
        Toast.makeText(PlanetDataActivity.this, buttonTag + "", Toast.LENGTH_SHORT).show();

        displayPlanet();

    }

    public void displayPlanet() {
        if (Integer.parseInt(buttonTag) >= 12) {
            buttonTag = "1";
        }
        switch (buttonTag) {
                case "1":
                    plData.setText(planet_data[0]);
                    break;
                case "2":
                    plData.setText(planet_data[1]);
                    break;
                case "3":
                    plData.setText(planet_data[2]);
                    break;
                case "4":
                    plData.setText(planet_data[3]);
                    break;
                case "5":
                    plData.setText(planet_data[4]);
                    break;
                case "6":
                    plData.setText(planet_data[5]);
                    break;
                case "7":
                    plData.setText(planet_data[6]);
                    break;
                case "8":
                    plData.setText(planet_data[7]);
                    break;
                case "9":
                    plData.setText(planet_data[8]);
                    break;
                case "10":
                    plData.setText(planet_data[9]);
                    break;
                case "11":
                    plData.setText(planet_data[10]);
                    break;
                default:
                    plData.setText("ERROR, TRY AGAIN!");

        }
    }

    public String displayNextPlanet(View view) {
        int oldButtonId = Integer.parseInt(buttonTag);
        Log.i("Old Button tag", oldButtonId + "");
        int planetNum = (oldButtonId +1);
        buttonTag = Integer.toString(planetNum);
        Log.i("New Button tag", buttonTag + "");
        displayPlanet();
        return buttonTag;
    }

    public void gotoQuiz(View view) {
        Intent i = new Intent(getApplicationContext(), Quiz.class);
        startActivity(i);
    }

}
