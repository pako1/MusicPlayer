package com.example.android.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PopActivity extends AppCompatActivity {

    @BindView(R.id.listview)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        ButterKnife.bind(this);
        final ArrayList<Band> bandArrayList = new ArrayList<>();

        bandArrayList.add(new Band(getString(R.string.band_mum), getString(R.string.Mum_song), R.drawable.momfurd));
        bandArrayList.add(new Band(getString(R.string.band_sam), getString(R.string.sam_song), R.drawable.samsmith));
        bandArrayList.add(new Band(getString(R.string.band_X), getString(R.string.X_song), R.drawable.xambes));
        bandArrayList.add(new Band(getString(R.string.band_Kod), getString(R.string.kod_song), R.drawable.highhopekod));
        bandArrayList.add(new Band(getString(R.string.band_Alex), getString(R.string.alex_song), R.drawable.alexclaredamn));
        bandArrayList.add(new Band(getString(R.string.band_ed), getString(R.string.ed_song), R.drawable.edshphoto));

        MusicAdapter musicAdapter = new MusicAdapter(PopActivity.this, 0, bandArrayList);

        listView.setAdapter(musicAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent playIntent = new Intent(PopActivity.this, MusicPlayerActivity.class);
                playIntent.putExtra("albumImage", bandArrayList.get(position).getImageBand());
                playIntent.putExtra("name", bandArrayList.get(position).getName());
                playIntent.putExtra("albumSong", bandArrayList.get(position).getAlbumSong());
                startActivity(playIntent);

            }
        });
    }
}
