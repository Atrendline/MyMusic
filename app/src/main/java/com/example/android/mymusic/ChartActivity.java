package com.example.android.mymusic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ChartActivity extends AppCompatActivity {
    public static String artist = "";
    public static String song = "";

    private ArrayList<Track> tracks = new ArrayList<Track>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_play );

        final ArrayList<Track> tracks = new ArrayList<Track>();
        tracks.add( new Track( "Justin Bieber and Bloodpop", "FRIENDS" ) );
        tracks.add( new Track( "George Ezra", "PARADISE" ) );
        tracks.add( new Track( "Kygo and Selena Gomez", "IT AIN'T ME" ) );
        tracks.add( new Track( "Logic/Marshmello", "EVERYDAY" ) );
        tracks.add( new Track( "Jason Derulo", "COLORS" ) );
        tracks.add( new Track( "The Palm Set", "THESE HIGHER MOUNTAINS" ) );
        tracks.add( new Track( "Luis Fonsi/Demi Lovato", "ÉCHAME LA CULPA" ) );
        tracks.add( new Track( "Justin Timberlake", "SAY SOMETHING" ) );
        tracks.add( new Track( "Calvin Harris", "ONE KISS" ) );
        tracks.add( new Track( "Katy Perry", "CHAINED TO THE RHYTHM" ) );

        TrackAdapter adapter = new TrackAdapter( this, tracks );

        ListView listView = (ListView) findViewById( R.id.list );

        listView.setAdapter( adapter );

        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent( ChartActivity.this, PlayActivity.class );
                intent.putExtra( "artistName", artist );
                intent.putExtra( "songName", song );
            }
        } );

    }
}




