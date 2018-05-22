package com.example.android.mymusic;

public class Track {
    private String artistName;
    private String songName;
    private String currentTrack;

    public Track(String artistName, String songName) {
        this.artistName = artistName;
        this.songName = songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getSongName() {
        return songName;
    }

}

