package com.example.android.musicplayer;

public class Category {

    private String name;
    private int AlbumImage;

    Category(String name,int AlbumImage){

        this.name = name;
        this.AlbumImage = AlbumImage;
    }

    public String getName() {
        return name;
    }

    public int getAlbumImage() {
        return AlbumImage;
    }
}
