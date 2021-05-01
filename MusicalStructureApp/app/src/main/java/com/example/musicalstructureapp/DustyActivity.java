package com.example.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class DustyActivity extends AppCompatActivity {
    // 3 of the 6 Intents sent when a song is selected
    public static final String EXTRA_BAND = "com.example.musicalstructureapp.EXTRA_BAND";
    public static final String EXTRA_ALBUM = "com.example.musicalstructureapp.EXTRA_ALBUM";
    public static final String EXTRA_ANOTHER_SONG = "com.example.musicalstructureapp.EXTRA_ANOTHER_SONG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        // Create a list of songs
        //@param Band name / Artist
        // @param Album the song is on
        // @param song name
        // Album art
        // song mp3 - Using a place holder / sample track as a proof of concept.
        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Dusty Springfield", "Dusty in Memphis",
                "Just a Little Lovin", R.drawable.dusty_album, R.raw.dusty_short));
        songs.add(new Song("Dusty Springfield", "Dusty in Memphis",
                "So Much Love", R.drawable.dusty_album, R.raw.dusty_short));
        songs.add(new Song("Dusty Springfield", "Dusty in Memphis",
                "Son of a Preacher Man", R.drawable.dusty_album, R.raw.dusty_short));
        songs.add(new Song("Dusty Springfield", "Dusty in Memphis",
                "I Don't Want to Hear It Anymore", R.drawable.dusty_album, R.raw.dusty_short));
        songs.add(new Song("Dusty Springfield", "Dusty in Memphis",
                "Don't Forget About Me", R.drawable.dusty_album, R.raw.dusty_short));
        songs.add(new Song("Dusty Springfield", "Dusty in Memphis",
                "Breakfast in Bed", R.drawable.dusty_album, R.raw.dusty_short));
        songs.add(new Song("Dusty Springfield", "Dusty in Memphis",
                "Just One Smile", R.drawable.dusty_album, R.raw.dusty_short));
        songs.add(new Song("Dusty Springfield", "Dusty in Memphis",
                "The Windmills of Your Mind", R.drawable.dusty_album, R.raw.dusty_short));
        songs.add(new Song("Dusty Springfield", "Dusty in Memphis",
                "In the Land of Make Believe", R.drawable.dusty_album, R.raw.dusty_short));
        songs.add(new Song("Dusty Springfield", "Dusty in Memphis",
                "No Easy Way Down", R.drawable.dusty_album, R.raw.dusty_short));
        songs.add(new Song("Dusty Springfield", "Dusty in Memphis",
                "I Can't Make It Alone", R.drawable.dusty_album, R.raw.dusty_short));

        // Create an {@link SongAdapter}, whose data source is a list of {@link Song}s. The
        // adapter knows how to create list items for each item in the list.
        SongAdapter adapter = new SongAdapter(this, songs, R.color.category_dusty);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link SongAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Song} in the list.
        listView.setAdapter(adapter);


        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Get the {@link Song} object at the given position the user clicked on
                Song song = songs.get(position);
                // Name of the band or Artist
                String bandName = song.getBandName();
                // Name of the Album the song is on
                String albumName = song.getAlbumName();
                // Name of the song
                String songName = song.getSongName();
                // The Art / image file of the song
                int art = song.getImageResourceId();
                // the song or track itself
                int track = song.getAudioResourceId();


                // Call the openNowPlayingActivity method and send the song vairables to be sent
                openNowPlayingActivity(bandName, albumName, songName, art, track);

            }
        });


    }

    /*
        // Open the openNowPlayingActivity
        // Send the details of the song that has been selected
     */
    public void openNowPlayingActivity(String bandName, String albumName, String songSentName, int art, int track) {
        Intent intent = new Intent(this, NowPlayingActivity.class);
        // source is the string to check where it is coming from
        intent.putExtra("source", "dusty");
        intent.putExtra(EXTRA_BAND, bandName);
        intent.putExtra(EXTRA_ALBUM, albumName);
        intent.putExtra(EXTRA_ANOTHER_SONG, songSentName);
        intent.putExtra("pics", art);
        intent.putExtra("track", track);
        startActivity(intent);
    }
}