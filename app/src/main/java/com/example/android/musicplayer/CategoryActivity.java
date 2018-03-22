package com.example.android.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryActivity extends AppCompatActivity {

    @BindView(R.id.gridview)
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        ArrayList<Category> categoryArrayList = new ArrayList<>();

        categoryArrayList.add(new Category(getString(R.string.cat_pop), R.drawable.mighty_widows_1x));
        categoryArrayList.add(new Category(getString(R.string.cat_rock), R.drawable.rock));
        categoryArrayList.add(new Category(getString(R.string.cat_rap), R.drawable.rap));
        categoryArrayList.add(new Category(getString(R.string.cat_reggae), R.drawable.aid_vinyl_4_1x));
        categoryArrayList.add(new Category(getString(R.string.cat_elec), R.drawable.vin_whyte_1x));
        categoryArrayList.add(new Category(getString(R.string.cat_clas), R.drawable.untitled_1_1x));

        CategoryAdapter categoryAdapter = new CategoryAdapter(this, 0, categoryArrayList);

        gridView.setAdapter(categoryAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent classicIntent = new Intent(CategoryActivity.this, PopActivity.class);
                    startActivity(classicIntent);
                } else if (position == 1) {
                    Intent classicIntent = new Intent(CategoryActivity.this, RockActivity.class);
                    startActivity(classicIntent);
                } else if (position == 2) {
                    Intent classicIntent = new Intent(CategoryActivity.this, RapActivity.class);
                    startActivity(classicIntent);
                }
            }
        });
    }
}
