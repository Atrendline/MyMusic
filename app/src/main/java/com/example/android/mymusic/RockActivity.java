package com.example.android.mymusic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class RockActivity extends AppCompatActivity {
    public String artist;
    public String track;

    private ArrayList<Track> tracks = new ArrayList<Track>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.track_list );

        final ArrayList<Track> tracks = new ArrayList<Track>();
        tracks.add( new Track( "Marilyn Manson", "HEARTH-SHAPED GLASSES" ) );
        tracks.add( new Track( "Snow Patrol", "SPITTING GAMES" ) );
        tracks.add( new Track( "The John Butler Trio", "CLOSE TO YOU" ) );
        tracks.add( new Track( "AWS", "SUMMER GONE" ) );
        tracks.add( new Track( "30 Second To Mars", "A BEAUTIFUL LIE" ) );
        tracks.add( new Track( "Linkin Park", "FAINT" ) );
        tracks.add( new Track( "Casper", "AUF UND DAFON" ) );
        tracks.add( new Track( "Stone Sour", "FABULESS" ) );
        tracks.add( new Track( "Luis Fonsi/Demi Lovato", "ÉCHAME LA CULPA" ) );
        tracks.add( new Track( "Beth Ditto", "I'M ALIVE" ) );

        final TrackAdapter adapter = new TrackAdapter( this, tracks );

        ListView listView = (ListView) findViewById( R.id.list );

        listView.setAdapter( adapter );

        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent( RockActivity.this, PlayActivity.class );
                intent.putExtra( "artistName", artist );
                intent.putExtra( "songName", track );
                startActivity( intent );
            }
        } );

    }
}

