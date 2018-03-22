package com.example.android.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RapActivity extends AppCompatActivity {

    @BindView(R.id.listview)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        ButterKnife.bind(this);

        final ArrayList<Band> bandArrayList = new ArrayList<>();

        bandArrayList.add(new Band(getString(R.string.band_eminem), getString(R.string.em_song), R.drawable.eminem));
        bandArrayList.add(new Band(getString(R.string.band_twop), getString(R.string.twopac_song), R.drawable.pac));
        bandArrayList.add(new Band(getString(R.string.band_jz), getString(R.string.jz_song), R.drawable.jz));
        bandArrayList.add(new Band(getString(R.string.band_drak), getString(R.string.drak_song), R.drawable.sofargone));
        bandArrayList.add(new Band(getString(R.string.band_dr), getString(R.string.dr_song), R.drawable.dr));
        bandArrayList.add(new Band(getString(R.string.band_eminem), getString(R.string.em2_song), R.drawable.eminem2));

        MusicAdapter musicAdapter = new MusicAdapter(RapActivity.this, 0, bandArrayList);

        listView.setAdapter(musicAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent playIntent = new Intent(RapActivity.this, MusicPlayerActivity.class);
                playIntent.putExtra("albumImage", bandArrayList.get(position).getImageBand());
                playIntent.putExtra("name", bandArrayList.get(position).getName());
                playIntent.putExtra("albumSong", bandArrayList.get(position).getAlbumSong());
                startActivity(playIntent);

            }
        });
    }
}
