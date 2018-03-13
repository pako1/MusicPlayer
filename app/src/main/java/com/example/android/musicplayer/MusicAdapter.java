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

import butterknife.BindView;
import butterknife.ButterKnife;


public class MusicAdapter extends ArrayAdapter<Band> {

    @BindView(R.id.bandImage)
    ImageView albumImage;
    @BindView(R.id.bandname)
    TextView bandName;
    @BindView(R.id.albumName)
    TextView albumName;

    MusicAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Band> bandlist) {
        super(context, resource, bandlist);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listview = convertView;

        if (listview == null) {
            listview = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            ButterKnife.bind(this, listview);
        }

        Band currentBand = getItem(position);

        if (currentBand != null) {
            albumImage.setImageResource(currentBand.getImageBand());
        }

        if (currentBand != null) {
            bandName.setText(currentBand.getName());
        }

        if (currentBand != null) {
            albumName.setText(currentBand.getAlbumSong());
        }

        return listview;
    }

}
