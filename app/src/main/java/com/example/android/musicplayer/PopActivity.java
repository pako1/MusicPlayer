package com.example.android.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        final ArrayList<Band> bandArrayList = new ArrayList<>();

        bandArrayList.add(new Band("Mumford and sons", "Live form South Africa", R.drawable.momfurd));
        bandArrayList.add(new Band("Sam smith", "The thrill of it all", R.drawable.samsmith));
        bandArrayList.add(new Band("X ambassadors", "The reason", R.drawable.xambes));
        bandArrayList.add(new Band("Kodaline", "High Hopes", R.drawable.highhopekod));
        bandArrayList.add(new Band("Alex clare", "Damn your eyes", R.drawable.alexclaredamn));
        bandArrayList.add(new Band("Ed Sheeran", "Perfect", R.drawable.edshphoto));

        MusicAdapter musicAdapter = new MusicAdapter(PopActivity.this, 0, bandArrayList);

        ListView listView = findViewById(R.id.listview);

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
