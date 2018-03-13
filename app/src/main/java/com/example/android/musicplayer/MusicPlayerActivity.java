package com.example.android.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MusicPlayerActivity extends AppCompatActivity {

    int playImage;
    String name;
    String albumsong;
    boolean isPressed;
    @BindView(R.id.bandname)
     TextView nameView;
    @BindView(R.id.songname)
     TextView song;
    @BindView(R.id.imageplaying)
     ImageView imageView;
    @BindView(R.id.seekBar)
     SeekBar seekbar;
    @BindView(R.id.secondsremained)
     TextView secondsRemainedView;
    @BindView(R.id.secondspassed)
     TextView secondsPassedView;
    @BindView(R.id.play)
     ImageButton play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        ButterKnife.bind(this);

        Intent playintent = getIntent();

        playImage = playintent.getIntExtra("albumImage", 0);

        name = playintent.getStringExtra("name");

        albumsong = playintent.getStringExtra("albumSong");

        nameView.setText(name);

        song.setText(albumsong);

        imageView.setImageResource(playImage);

        seekbar.setMax(180);

        secondsRemainedView.setText(R.string.min3);

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

                String totalP = minString + ":" + secondString;
                secondsPassedView.setText(totalP);

                int minRem = (seekBar.getMax() - progress) / 60;
                int secRem = (seekBar.getMax() - progress) - minRem * 60;
                String secRstring = Integer.toString(secRem);
                String minRstring = Integer.toString(minRem);

                if (secRstring.equalsIgnoreCase("0")) {
                    secRstring = "00";
                }
                String totalR = minRstring + ":" + secRstring;
                secondsRemainedView.setText(totalR);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

        });

    }

    @OnClick(R.id.play)
    public void play() {
        if (isPressed) {
            play.setBackgroundResource(R.drawable.ic_pause);
        } else {
            play.setBackgroundResource(R.drawable.ic_play_button);
        }
        isPressed = !isPressed;
    }

}
