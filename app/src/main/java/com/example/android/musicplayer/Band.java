package com.example.android.musicplayer;

public class Band {

    private String name;
    private String albumSong;
    private int ImageBand;

    Band(String name, String albumSong, int ImageBand) {

        this.name = name;
        this.albumSong = albumSong;
        this.ImageBand = ImageBand;

    }

    public String getName() {
        return name;
    }

    public String getAlbumSong() {
        return albumSong;
    }

    public int getImageBand() {
        return ImageBand;
    }
}
