package com.example.newtsk;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class activity_history extends AppCompatActivity {

    private ListView listViewHistory;
    private ArrayList<String> taskHistory;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        listViewHistory = findViewById(R.id.listViewHistory);
        Button buttonClearHistory = findViewById(R.id.buttonClearHistory);

        // Retrieve task history from the Intent
        taskHistory = getIntent().getStringArrayListExtra("task_history");
        if (taskHistory == null) {
            taskHistory = new ArrayList<>();
        }

        // Set up the adapter to display task history
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskHistory);
        listViewHistory.setAdapter(adapter);

        // Set up Clear History button functionality
        buttonClearHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskHistory.clear();  // Clear the list
                adapter.notifyDataSetChanged();  // Notify the adapter of data change
                Toast.makeText(activity_history.this, "History cleared", Toast.LENGTH_SHORT).show();
            }
        });

        // Enable the back button in the toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle the back button in the toolbar
        if (item.getItemId() == android.R.id.home) {
            finish(); // Close this activity and go back
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
