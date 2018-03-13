package com.example.android.musicplayer;

public class Category {

    private String name;
    private int albumImage;

    Category(String name,int albumImage){

        this.name = name;
        this.albumImage = albumImage;
    }

    public String getName() {
        return name;
    }

    public int getAlbumImage() {
        return albumImage;
    }
}
