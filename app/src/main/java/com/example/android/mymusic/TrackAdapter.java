package com.example.android.mymusic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TrackAdapter extends ArrayAdapter<Track> {
    private static final String LOG_TAG = TrackAdapter.class.getSimpleName();

    public TrackAdapter(Context context, ArrayList<Track> tracks) {
        super( context, 0, tracks );
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from( getContext() ).inflate(
                    R.layout.list_item, parent, false );
        }

        Track currentTrack = getItem( position );

        TextView songTextView = (TextView) listItemView.findViewById( R.id.song_text_view );

        songTextView.setText( currentTrack.getSongName() );

        TextView artistTextView = (TextView) listItemView.findViewById( R.id.artist_text_view );

        artistTextView.setText( currentTrack.getArtistName() );

        return listItemView;
    }

}

