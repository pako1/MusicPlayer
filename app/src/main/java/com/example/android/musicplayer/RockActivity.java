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

public class RockActivity extends AppCompatActivity {

    @BindView(R.id.listview)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        ButterKnife.bind(this);

        final ArrayList<Band> bandArrayList = new ArrayList<>();

        bandArrayList.add(new Band("The Beatles", "Abbey Road", R.drawable.abbey1));
        bandArrayList.add(new Band("Rolling Stones", "blue & lonesome", R.drawable.blueandlan1));
        bandArrayList.add(new Band("Linking Park", "Living Things", R.drawable.lp1));
        bandArrayList.add(new Band("Led Zeppelin", "Led Zeppelin", R.drawable.ledz1));
        bandArrayList.add(new Band("Guns & Roses", "The Spaghetti incident?", R.drawable.guns1));
        bandArrayList.add(new Band("The Doors", "The doors", R.drawable.thedoors1));

        MusicAdapter musicAdapter = new MusicAdapter(RockActivity.this, 0, bandArrayList);

        listView.setAdapter(musicAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent playIntent = new Intent(RockActivity.this, MusicPlayerActivity.class);
                playIntent.putExtra("albumImage", bandArrayList.get(position).getImageBand());
                playIntent.putExtra("name", bandArrayList.get(position).getName());
                playIntent.putExtra("albumSong", bandArrayList.get(position).getAlbumSong());
                startActivity(playIntent);

            }
        });
    }
}
