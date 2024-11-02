package com.example.newtsk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listViewTasks;
    private ArrayList<String> tasks;
    private ArrayAdapter<String> adapter;
    private static final int ADD_TASK_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewTasks = findViewById(R.id.listViewTasks);
        Button buttonAddTask = findViewById(R.id.buttonAddTask);
        Button buttonSettings = findViewById(R.id.buttonSettings);
        Button buttonCategories = findViewById(R.id.buttonCategories);
        Button buttonBackToLogin = findViewById(R.id.buttonBackToLogin);
        Button buttonHistory = findViewById(R.id.buttonHistory);  // View History button

        tasks = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasks);
        listViewTasks.setAdapter(adapter);

        buttonAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddTaskActivity.class);
                startActivityForResult(intent, ADD_TASK_REQUEST);
            }
        });

        buttonHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to launch HistoryActivity
                Intent intent = new Intent(MainActivity.this, activity_history.class);
                intent.putStringArrayListExtra("task_history", tasks);
                startActivity(intent);
            }
        });

        // Other butto
        // ns (Settings, Categories, Back to Login)
        buttonSettings.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        });

        buttonCategories.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TaskCategoriesActivity.class);
            startActivity(intent);
        });

        buttonBackToLogin.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, activity_history.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });

        // Handle task addition
        listViewTasks.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, AddTaskActivity.class);
            intent.putExtra("task_title", tasks.get(position));
            startActivityForResult(intent, ADD_TASK_REQUEST);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_TASK_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            String newTask = data.getStringExtra("new_task");
            if (newTask != null) {
                tasks.add(newTask);
                adapter.notifyDataSetChanged();
                Toast.makeText(this, "Task added successfully", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
