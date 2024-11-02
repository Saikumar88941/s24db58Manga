package com.example.newtsk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TaskCategoriesActivity extends AppCompatActivity {

    private ListView listViewCategories;
    private ArrayList<String> categories;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acactivity_task_categories);

        listViewCategories = findViewById(R.id.listViewCategories);
        Button buttonBack = findViewById(R.id.buttonBack);

        categories = new ArrayList<>();
        // Sample categories, you might want to load these from a database or another source
        categories.add("Work");
        categories.add("Personal");
        categories.add("Shopping");
        categories.add("Health");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, categories);
        listViewCategories.setAdapter(adapter);

        // Set a click listener on the back button
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Close TaskCategoriesActivity
            }
        });

        // Optional: Click listener for item clicks in the category list
        listViewCategories.setOnItemClickListener((parent, view, position, id) -> {
            String selectedCategory = categories.get(position);
            Toast.makeText(TaskCategoriesActivity.this, "Selected: " + selectedCategory, Toast.LENGTH_SHORT).show();
            // You can add functionality here to edit or delete the selected category
        });
    }
}
