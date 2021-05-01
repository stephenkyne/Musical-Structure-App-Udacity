package com.example.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class NowPlayingActivity extends AppCompatActivity {
    // The Track / song selected is send to this via an Intent
    int trackToPlay;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);
        // Sets a String with a message to select a song
        String selectSong = getString(R.string.select_song);
        /*
            // Finds the ID's and Names the TextView used to display song details
             // Used in Intents
         */
        TextView bandNameTextView = findViewById(R.id.band_playing_text_view);
        TextView albumNameNameTextView = findViewById(R.id.album_playing_text_view);
        TextView songToPlayTextView = findViewById(R.id.song_playing_text_view);
        // ID for this nowPlayingActivity.xml
        // Used to set the colour that matches the band / artist
        // Used in Intents
        View mainLayoutView = findViewById(R.id.now_playing_layout_main);
        // Find and names the ImageView where the song Art is displayed
        // Used in Intents
        ImageView artImageView = findViewById(R.id.art_playing_image_view);

        /*
             // Name and link ID to the ImageViews that handle,
            // Stop, Play and Pause.
         */
        ImageView playImage = findViewById(R.id.play_image);
        ImageView pauseImage = findViewById(R.id.pause_image);
        ImageView stopImage = findViewById(R.id.stop_image);

        /*
            // The Intents are selected by the Activity that sent them
         */
        Intent intent = getIntent();
        //This works out the source of the indent
        // @param "source", has the name of the Activity that sent them
        String from = intent.getStringExtra("source");
        // From the MetllicaActivity
        if ("metallica".equals(from))
        {
            // Band / Artist name received
            String bandName = intent.getStringExtra(MetallicaActivity.EXTRA_BAND);
            bandNameTextView.setText(bandName);

            // Album name received
            String albumName = intent.getStringExtra(MetallicaActivity.EXTRA_ALBUM);
            albumNameNameTextView.setText(albumName);

            // Song name received
            String songToPlay = intent.getStringExtra(MetallicaActivity.EXTRA_ANOTHER_SONG);
            songToPlayTextView.setText(songToPlay);

           // Toast.makeText(NowPlayingActivity.this,songToPlay, Toast.LENGTH_SHORT).show();
            // Art of the Track to be used
            // @Param "pics" used a different method from above with naming the Intent
            // The pre defined methods did not work for me, Re EXTRA_ART
            int artToShow = intent.getIntExtra("pics",0);

            artImageView.setImageResource(artToShow);
            /// Change the color of the Activity to the same as the song
            mainLayoutView.setBackgroundColor(getResources().getColor(R.color.category_metallica));
            /*
                // Play and Pause Buttons are disabled by default to stop errors in media playback
             */

            // Enable to stop Button
            stopImage.setEnabled(true);
            // Enable to play Button
            playImage.setEnabled(true);
            // enable the pause Button
            pauseImage.setEnabled(true);
            // The song that is sent to be played
            // @Param "tack" is the mp3 file that is selected to be played
            trackToPlay = intent.getIntExtra("track",0);
            // Track sent tot he mediaPlayer
            mediaPlayer = MediaPlayer.create(this, trackToPlay);
            // Method to play the track is called.
            playTheTrack();
            // From the DustyActivity
        } else if ("dusty".equals(from))
        {
            // Band / Artist name received
            String bandName = intent.getStringExtra(DustyActivity.EXTRA_BAND);
            bandNameTextView.setText(bandName);

            // Album name received
            String albumName = intent.getStringExtra(DustyActivity.EXTRA_ALBUM);
            albumNameNameTextView.setText(albumName);

            // Song name received
            String songToPlay = intent.getStringExtra(DustyActivity.EXTRA_ANOTHER_SONG);
            songToPlayTextView.setText(songToPlay);

            // Toast.makeText(NowPlayingActivity.this,songToPlay, Toast.LENGTH_SHORT).show();
            // Art of the Track to be used
            // @Param "pics" used a different method from above with naming the Intent
            // The pre defined methods did not work for me, Re EXTRA_ART
            int artToShow = intent.getIntExtra("pics",0);
            artImageView.setImageResource(artToShow);
            /// Change the color of the Activity to the same as the song
            mainLayoutView.setBackgroundColor(getResources().getColor(R.color.category_dusty));
             /*
                // Play and Pause Buttons are disabled by default to stop errors in media playback
             */

            // Enable to stop Button
            stopImage.setEnabled(true);
            // Enable to play Button
            playImage.setEnabled(true);
            // enable the pause Button
            pauseImage.setEnabled(true);

            // The song that is sent to be played
            // @Param "tack" is the mp3 file that is selected to be played
            trackToPlay = intent.getIntExtra("track",0);
            // Track sent tot he mediaPlayer

            mediaPlayer = MediaPlayer.create(this, trackToPlay);
            // Method to play the track is called.
            playTheTrack();
            // From the MarvinActivity
        }else if ("marvin".equals(from))
        {
            // Band / Artist name received
            String bandName = intent.getStringExtra(MarvinActivity.EXTRA_BAND);

            bandNameTextView.setText(bandName);

            // Album name received
            String albumName = intent.getStringExtra(MarvinActivity.EXTRA_ALBUM);
            albumNameNameTextView.setText(albumName);

            // Song name received
            String songToPlay = intent.getStringExtra(MarvinActivity.EXTRA_ANOTHER_SONG);
            songToPlayTextView.setText(songToPlay);

            // Toast.makeText(NowPlayingActivity.this,songToPlay, Toast.LENGTH_SHORT).show();
            // Art of the Track to be used
            // @Param "pics" used a different method from above with naming the Intent
            // The pre defined methods did not work for me, Re EXTRA_ART
            int artToShow = intent.getIntExtra("pics",0);
            artImageView.setImageResource(artToShow);

            // The song that is sent to be played
            // @Param "tack" is the mp3 file that is selected to be played
            trackToPlay = intent.getIntExtra("track",0);

            /// Change the color of the Activity to the same as the song
            mainLayoutView.setBackgroundColor(getResources().getColor(R.color.category_marvin));
             /*
                // Play and Pause Buttons are disabled by default to stop errors in media playback
             */


            // Enable to stop Button
            stopImage.setEnabled(true);
            // Enable to play Button
            playImage.setEnabled(true);
            // enable the pause Button
            pauseImage.setEnabled(true);

            // Track sent tot he mediaPlayer
            mediaPlayer = MediaPlayer.create(this, trackToPlay);
            // Method to play the track is called.
            playTheTrack();
        }// From the PavarottiActivity
    else if ("pavarotti".equals(from))
    {
        // Band / Artist name received
        String bandName = intent.getStringExtra(PavarottiActivity.EXTRA_BAND);
        bandNameTextView.setText(bandName);

        // Album name received
        String albumName = intent.getStringExtra(PavarottiActivity.EXTRA_ALBUM);
        albumNameNameTextView.setText(albumName);

        // Song name received
        String songToPlay = intent.getStringExtra(PavarottiActivity.EXTRA_ANOTHER_SONG);
        songToPlayTextView.setText(songToPlay);

        // Toast.makeText(NowPlayingActivity.this,songToPlay, Toast.LENGTH_SHORT).show();
        // Art of the Track to be used
        // @Param "pics" used a different method from above with naming the Intent
        // The pre defined methods did not work for me, Re EXTRA_ART
        int artToShow = intent.getIntExtra("pics",0);
        artImageView.setImageResource(artToShow);

        /// Change the color of the Activity to the same as the song
        mainLayoutView.setBackgroundColor(getResources().getColor(R.color.category_pavarotti));

         /*
                // Play and Pause Buttons are disabled by default to stop errors in media playback
             */

        // Enable to stop Button
        stopImage.setEnabled(true);
        // Enable to play Button
        playImage.setEnabled(true);
        // enable the pause Button
        pauseImage.setEnabled(true);

        // The song that is sent to be played
        // @Param "tack" is the mp3 file that is selected to be played
        trackToPlay = intent.getIntExtra("track",0);
        // Track sent tot he mediaPlayer
        mediaPlayer = MediaPlayer.create(this, trackToPlay);
        // Method to play the track is called.
        playTheTrack();
    }

        /*
        plays the song when imageview is clicked
     */
        playImage.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                if (mediaPlayer != null) {
                    playTheTrack();
                }
            }
        });

    /*
        Pauses the song when imageview is clicked
     */
        pauseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer != null) {
                    mediaPlayer.pause();
                }
            }
        });

        // Call the reaseMediaPlayer method and stop playing completely.

        stopImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Disable to play Button
                playImage.setEnabled(false);
                // Disable to pause Button
                pauseImage.setEnabled(false);
                Toast.makeText(NowPlayingActivity.this, selectSong, Toast.LENGTH_SHORT).show();
                releaseMediaPlayer();
            }
        });


    }
    /*
        // Release The media player
        // Called
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }

    /*
        // Play the Track
        // called by Intents
     */
     private void playTheTrack(){
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                releaseMediaPlayer();
                String songFinished = getString(R.string.song_finished);
                Toast.makeText(NowPlayingActivity.this, songFinished, Toast.LENGTH_SHORT).show();
            }
        });
    }



    }