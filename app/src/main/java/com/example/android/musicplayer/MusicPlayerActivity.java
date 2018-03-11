package com.example.android.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MusicPlayerActivity extends AppCompatActivity {

    int PlayImage;
    String name;
    String albumsong;
    private TextView nameView;
    private TextView song;
    private ImageView imageView;
    private SeekBar seekbar;
    private TextView secondsRemainedview;
    private TextView secondspassedview;
    private ImageButton play;
    private boolean isPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        Intent playintent = getIntent();
        PlayImage = playintent.getIntExtra("albumImage", 0);
        name = playintent.getStringExtra("name");
        albumsong = playintent.getStringExtra("albumSong");
        setup();
        nameView.setText(name);
        song.setText(albumsong);
        imageView.setImageResource(PlayImage);
        seekbar.setMax(180);
        secondsRemainedview.setText("3:00");

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPressed) {
                    play.setBackgroundResource(R.drawable.ic_pause);
                } else {
                    play.setBackgroundResource(R.drawable.ic_play_button);
                }
                isPressed = !isPressed;
            }
        });

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int min = progress / 60;
                int sec = progress - min * 60;
                String secondString = Integer.toString(sec);
                String minString = Integer.toString(min);

                if (secondString.equalsIgnoreCase("0")) {
                    secondString = "00";
                }

                secondspassedview.setText(minString + ":" + secondString);

                int minRem = (seekBar.getMax() - progress) / 60;
                int secRem = (seekBar.getMax() - progress) - minRem * 60;
                String secRstring = Integer.toString(secRem);
                String minRstring = Integer.toString(minRem);

                if (secRstring.equalsIgnoreCase("0")) {
                    secRstring = "00";
                }

                secondsRemainedview.setText(minRstring + ":" + secRstring);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

        });

    }

    private void setup() {

        play = findViewById(R.id.play);
        seekbar = findViewById(R.id.seekBar);
        nameView = findViewById(R.id.bandname);
        song = findViewById(R.id.songname);
        imageView = findViewById(R.id.imageplaying);
        secondspassedview = findViewById(R.id.secondspassed);
        secondsRemainedview = findViewById(R.id.secondsremained);

    }

}
