package com.example.android.mymusic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Latin_BeatsActivity extends AppCompatActivity {
    public String artist;
    public String track;

    private ArrayList<Track> tracks = new ArrayList<Track>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.track_list );

        final ArrayList<Track> tracks = new ArrayList<Track>();
        tracks.add( new Track( "D.OZI feat J Alvarez", "SI TU NO ESTAS" ) );
        tracks.add( new Track( "Wisin and Yandel", "HIPNOTIZAME" ) );
        tracks.add( new Track( "Cosculluela feat Daddy Yankee", "A DONDE VOY" ) );
        tracks.add( new Track( "Manolito Simone Y Su Trabuco", "COMUNICATE" ) );
        tracks.add( new Track( "Dente De Zona", "BAILANDO" ) );
        tracks.add( new Track( "Don Omar feat Yunel Cruz", "LA LLAVE DE MI CORAZON" ) );
        tracks.add( new Track( "Elvis Crespo", "PINTA ME" ) );
        tracks.add( new Track( "Badoxa", "CONTROLA" ) );
        tracks.add( new Track( "Angel Lopez", "HAST CUANDO" ) );
        tracks.add( new Track( "Luis Fonsi/Demi Lovato", "ÉCHAME LA CULPA" ) );

        final TrackAdapter adapter = new TrackAdapter( this, tracks );

        ListView listView = (ListView) findViewById( R.id.list );

        listView.setAdapter( adapter );

        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent( Latin_BeatsActivity.this, PlayActivity.class );
                intent.putExtra( "artistName", artist );
                intent.putExtra( "songName", track );
                startActivity( intent );
            }
        } );

    }
}

