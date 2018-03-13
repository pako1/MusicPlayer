package com.example.android.musicplayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CategoryAdapter extends ArrayAdapter<Category> {

    @BindView(R.id.categoryImage)
    ImageView AlbumImageView;

    @BindView(R.id.categoryName)
    TextView Title;

    CategoryAdapter(Context context, int resource, ArrayList<Category> categories) {
        super(context, resource, categories);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        Category currentCategory = getItem(position);

        View griditemView = convertView;

        if (griditemView == null) {
            griditemView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
            ButterKnife.bind(this, griditemView);
        }

        if (currentCategory != null) {
            AlbumImageView.setImageResource(currentCategory.getAlbumImage());
        }

        if (currentCategory != null) {
            Title.setText(currentCategory.getName());
        }

        return griditemView;
    }

}
