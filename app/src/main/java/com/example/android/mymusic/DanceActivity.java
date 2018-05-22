package com.example.android.mymusic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class DanceActivity extends AppCompatActivity {
    public String artist;
    public String track;


    private ArrayList<Track> tracks = new ArrayList<Track>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.track_list );

        final ArrayList<Track> tracks = new ArrayList<Track>();
        tracks.add( new Track( "DJ Snake and Alunageorge ", "YOU KNOW YOU LIKE" ) );
        tracks.add( new Track( "Tujamo", "BOOTY BOUNCE" ) );
        tracks.add( new Track( "Jax Jones", "BREATHE" ) );
        tracks.add( new Track( "Dimitri Vegas & Like Mike", "OCARINA" ) );
        tracks.add( new Track( "The Chainsmokers & Coldplay", "SOMETHING JUST LIKE THIS" ) );
        tracks.add( new Track( "Duke Dumont", "I GOT U (ANI QUINN REMIX)" ) );
        tracks.add( new Track( "Sigala", "EASY LOVE (CLUB MIX)" ) );
        tracks.add( new Track( "Zedd", "I WANT YOU TO KNOW" ) );
        tracks.add( new Track( "Bakermat", "ONE DAY" ) );
        tracks.add( new Track( "99 Souls", "THE GIRL IS MINE" ) );

        final TrackAdapter adapter = new TrackAdapter( this, tracks );

        ListView listView = (ListView) findViewById( R.id.list );

        listView.setAdapter( adapter );

        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent( DanceActivity.this, PlayActivity.class );
                intent.putExtra( "artistName", artist );
                intent.putExtra( "songName", track );
                startActivity( intent );
            }
        } );
    }
}

