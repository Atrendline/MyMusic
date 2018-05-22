package com.example.android.mymusic;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlayActivity extends AppCompatActivity {
    @Nullable
    public String artist;
    @Nullable
    public String track;
    TextView artistName;
    TextView songName;
    TextView artistTextView;
    TextView songTextView;
    public ArrayList<Track> tracks;
    ListView listView;
    ImageView previousButton;
    ImageView playButton;
    ImageView nextButton;
    Drawable drawable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_play );

        artistTextView = (TextView) findViewById( R.id.artist_text_view );
        songTextView = (TextView) findViewById( R.id.song_text_view );
        listView = (ListView) findViewById( R.id.list );
        playButton = (ImageView) findViewById( R.id.play_button );
        previousButton = (ImageView) findViewById( R.id.previous_button );
        nextButton = (ImageView) findViewById( R.id.next_button );

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            track = bundle.getString( "songName" );
        }

        artistTextView.setText( String.valueOf( artist ) );
        songTextView.setText( String.valueOf( track ) );


        // Set play or pause button to work
        final ImageView playOrPause = (ImageView) findViewById( R.id.play_button );
        playOrPause.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable drawable = playOrPause.getDrawable();
                if (drawable.getConstantState().equals( getResources().getDrawable( R.drawable.play_black ).getConstantState() )) {
                    playOrPause.setImageResource( R.drawable.pause_black );
                } else {
                    playOrPause.setImageResource( R.drawable.play_black );
                }
            }
        } );

    }
}
