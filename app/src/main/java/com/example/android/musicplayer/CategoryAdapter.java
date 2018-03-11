package com.example.android.musicplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class CategoryAdapter extends ArrayAdapter<Category> {

    public CategoryAdapter(Context context, int resource, ArrayList<Category> categories) {
        super(context, resource, categories);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Category currentCategory = getItem(position);

        View griditemView = convertView;

        if (griditemView == null) {
            griditemView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        ImageView AlbumImageView = griditemView.findViewById(R.id.categoryImage);
        AlbumImageView.setImageResource(currentCategory.getAlbumImage());

        TextView Title = griditemView.findViewById(R.id.categoryName);
        Title.setText(currentCategory.getName());

        return griditemView;
    }

}
