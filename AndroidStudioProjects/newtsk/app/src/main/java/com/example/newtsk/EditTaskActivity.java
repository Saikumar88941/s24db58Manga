package com.example.newtsk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.newtsk.R;

public class EditTaskActivity extends AppCompatActivity {

    private EditText editTextTaskTitle;
    private EditText editTextTaskDescription;
    private EditText editTextDueDate;
    private Spinner spinnerPriority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);

        editTextTaskTitle = findViewById(R.id.editTextTaskTitle);
        editTextTaskDescription = findViewById(R.id.editTextTaskDescription);
        editTextDueDate = findViewById(R.id.editTextDueDate);
        spinnerPriority = findViewById(R.id.spinnerPriority);

        // Set up spinner for priority
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.priority_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPriority.setAdapter(adapter);

        // Retrieve the task details from the intent
        Intent intent = getIntent();
        String taskTitle = intent.getStringExtra("task_title");
        String taskDescription = intent.getStringExtra("task_description");
        String taskDueDate = intent.getStringExtra("task_due_date");
        String taskPriority = intent.getStringExtra("task_priority");

        // Set the task details into the EditText fields
        editTextTaskTitle.setText(taskTitle);
        editTextTaskDescription.setText(taskDescription);
        editTextDueDate.setText(taskDueDate);

        // Set spinner position based on task priority
        int spinnerPosition = adapter.getPosition(taskPriority);
        spinnerPriority.setSelection(spinnerPosition);

        Button buttonUpdateTask = findViewById(R.id.buttonUpdateTask);
        Button buttonDeleteTask = findViewById(R.id.buttonDeleteTask);

        buttonUpdateTask.setOnClickListener(v -> {
            // Get updated task details
            String updatedTitle = editTextTaskTitle.getText().toString();
            String updatedDescription = editTextTaskDescription.getText().toString();
            String updatedDueDate = editTextDueDate.getText().toString();
            String updatedPriority = spinnerPriority.getSelectedItem().toString();

            // Update logic here (e.g., save changes to database or a list)
            // Assuming success for demo
            Toast.makeText(EditTaskActivity.this, "Task updated successfully", Toast.LENGTH_SHORT).show();
            finish(); // Return to the previous activity
        });

        buttonDeleteTask.setOnClickListener(v -> {
            // Delete logic here (e.g., remove from database or a list)
            // Assuming success for demo
            Toast.makeText(EditTaskActivity.this, "Task deleted successfully", Toast.LENGTH_SHORT).show();
            finish(); // Return to the previous activity
        });
    }
}