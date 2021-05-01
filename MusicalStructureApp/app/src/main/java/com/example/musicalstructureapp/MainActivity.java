package com.example.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the View that shows the metallica category
        TextView metallica = findViewById(R.id.metallica_text_view);

        // Set a click listener on that View
        metallica.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent metallicaIntent = new Intent(MainActivity.this, MetallicaActivity.class);

                // Start the new activity
                startActivity(metallicaIntent);
            }
        });

        // Find the View that shows the Pavarotti category
        TextView pavarotti = (TextView) findViewById(R.id.pavarotti_text_view);

        // Set a click listener on that View
        pavarotti.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent pavarottiIntent = new Intent(MainActivity.this, PavarottiActivity.class);

                // Start the new activity
                startActivity(pavarottiIntent);
            }
        });

        // Find the View that shows the Marvin category
        TextView marvin = (TextView) findViewById(R.id.marvin_text_view);

        // Set a click listener on that View
        marvin.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent marvinIntent = new Intent(MainActivity.this, MarvinActivity.class);

                // Start the new activity
                startActivity(marvinIntent);
            }
        });

        // Find the View that shows the Dusty category
        TextView dusty = (TextView) findViewById(R.id.dusty_text_view);

        // Set a click listener on that View
        dusty.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent dustyIntent = new Intent(MainActivity.this, DustyActivity.class);

                // Start the new activity
                startActivity(dustyIntent);
            }
        });
        // Find the View that shows the Dusty category
        TextView nowPlaying = (TextView) findViewById(R.id.now_playing_text_view);

        // Set a click listener on that View
        nowPlaying.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent nowPlayingIntent = new Intent(MainActivity.this, NowPlayingActivity.class);

                // Start the new activity
                startActivity(nowPlayingIntent);
            }
        });

    }
}