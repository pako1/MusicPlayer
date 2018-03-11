package com.example.android.musicplayer;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class MusicAdapter extends ArrayAdapter<Band> {

    public MusicAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Band> bandlist) {
        super(context, resource, bandlist);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listview = convertView;

        if (listview == null) {
            listview = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Band currentBand = getItem(position);

        ImageView albumImage = listview.findViewById(R.id.bandImage);
        albumImage.setImageResource(currentBand.getImageBand());

        TextView bandName = listview.findViewById(R.id.bandname);
        bandName.setText(currentBand.getName());

        TextView albumName = listview.findViewById(R.id.albumName);
        albumName.setText(currentBand.getAlbumSong());

        return listview;
    }

}
