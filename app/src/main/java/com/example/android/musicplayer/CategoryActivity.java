package com.example.android.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        ArrayList<Category> categoryArrayList = new ArrayList<>();

        categoryArrayList.add(new Category("Pop", R.drawable.mighty_widows_1x));
        categoryArrayList.add(new Category("Rock", R.drawable.rock));
        categoryArrayList.add(new Category("Rap", R.drawable.rap));
        categoryArrayList.add(new Category("Reggae", R.drawable.aid_vinyl_4_1x));
        categoryArrayList.add(new Category("Electronic", R.drawable.vin_whyte_1x));
        categoryArrayList.add(new Category("Classical", R.drawable.untitled_1_1x));

        CategoryAdapter categoryAdapter = new CategoryAdapter(this, 0, categoryArrayList);

        GridView gridView = findViewById(R.id.gridview);

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
