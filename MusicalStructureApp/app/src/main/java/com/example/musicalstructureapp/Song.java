package com.example.musicalstructureapp;

public class Song {

    /**
     * Name of the Band
     */
    private String mBandName;

    /**
     * Name of the Album
     */
    private String mAlbumName;

    /**
     * Name of the Song
     */
    private String mSongName;

    /**
     * Image of the album of the song
     */
    private int mImageResourceId;

    /**
     * Audio resource ID for the word
     */
    private int mAudioResourceId;

    /**
     * Create a new Word object.
     *
     * @param bandName        is the name of the Band / Artist the song is performed by
     * @param albumName       is the name of the Album the song is on
     * @param songName        The name of the song that is selected
     * @param imageResourceId is the drawable resource ID for the image associated with the song
     */
    public Song(String bandName, String albumName, String songName, int imageResourceId, int audioResourceId) {
        mBandName = bandName;
        mAlbumName = albumName;
        mSongName = songName;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    /**
     * Get the band / artist name of the song.
     */
    public String getBandName() {
        return mBandName;
    }

    /**
     * Get the Album name of the song.
     */
    public String getAlbumName() {
        return mAlbumName;
    }

    /**
     * Get the song name.
     */
    public String getSongName() {
        return mSongName;
    }


    /**
     * Return the image resource ID of the word.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Return the song, mp3 file for the song
     */
    public int getAudioResourceId() {
        return mAudioResourceId;
    }
}
