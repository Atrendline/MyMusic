package com.example.android.mymusic;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlayActivity extends AppCompatActivity {
    TextView artistTextView;
    TextView songTextView;
    private ArrayList<Track> tracks;
    ListView listView;
    ImageView previousButton;
    ImageView playButton;
    ImageView nextButton;
    Drawable drawable;
    int currentPosition;
    ChartActivity ca = new ChartActivity();
    DanceActivity da = new DanceActivity();
    Latin_BeatsActivity la = new Latin_BeatsActivity();
    RockActivity ra = new RockActivity();
    String artistName = "";
    String songName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_play );

        //Show the currently playing song
        artistTextView = (TextView) findViewById( R.id.artist_text_view );
        songTextView = (TextView) findViewById( R.id.song_text_view );

        //Show the previous button
        previousButton = (ImageView) findViewById( R.id.previous_button );

        //Show the play and pause button
        playButton = (ImageView) findViewById( R.id.play_button );

        //Show the next button
        nextButton = (ImageView) findViewById( R.id.next_button );

        listView = (ListView) findViewById( R.id.list );

        //Get a data from activities
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String artistName = "";
        String songName = "";

        if (bundle != null) {
            artistName = bundle.getString( "artistName" );
            songName = bundle.getString( "songName" );
        }

        //Put the artist and the song into the textview
        artistTextView.setText( tracks.get( currentPosition ).getArtistName() );
        songTextView.setText( tracks.get( currentPosition ).getSongName() );

        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                artistTextView.setText( tracks.get( position ).getArtistName() );
                songTextView.setText( tracks.get( position ).getSongName() );
            }
        } );


        //Set the play or pause button to work
        playButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawable = playButton.getDrawable();
                if (drawable.getConstantState().equals( getResources().getDrawable( R.drawable.play_black ).getConstantState() )) {
                    playButton.setImageResource( R.drawable.pause_black );
                } else {
                    playButton.setImageResource( R.drawable.play_black );
                }
            }
        } );

        //Set the previous button to work
        previousButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentPosition == 0) {
                    currentPosition = tracks.size() - 1;
                    artistTextView.setText( tracks.get( currentPosition ).getArtistName() );
                    songTextView.setText( tracks.get( currentPosition ).getSongName() );
                } else
                    currentPosition -= 1;
                artistTextView.setText( tracks.get( currentPosition ).getArtistName() );
                songTextView.setText( tracks.get( currentPosition ).getSongName() );
            }
        } );

        //Set the next button to work
        nextButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentPosition == tracks.size() - 1) {
                    currentPosition = 0;
                    artistTextView.setText( tracks.get( currentPosition ).getArtistName() );
                    songTextView.setText( tracks.get( currentPosition ).getSongName() );
                } else {
                    currentPosition += 1;
                    artistTextView.setText( tracks.get( currentPosition ).getArtistName() );
                    songTextView.setText( tracks.get( currentPosition ).getSongName() );
                }
            }
        } );

    }
}

