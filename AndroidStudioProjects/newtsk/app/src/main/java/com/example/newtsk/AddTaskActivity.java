package com.example.newtsk;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class AddTaskActivity extends AppCompatActivity {

    private EditText editTextTaskTitle, editTextTaskDescription, editTextDueDate, editTextTime;
    private Spinner spinnerPriority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        editTextTaskTitle = findViewById(R.id.editTextTaskTitle);
        editTextTaskDescription = findViewById(R.id.editTextTaskDescription);
        editTextDueDate = findViewById(R.id.editTextDueDate);
        editTextTime = findViewById(R.id.editTextTime);
        spinnerPriority = findViewById(R.id.spinnerPriority);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.priority_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPriority.setAdapter(adapter);

        // Show date picker dialog
        editTextDueDate.setOnClickListener(v -> showDatePickerDialog());
        // Show time picker dialog
        editTextTime.setOnClickListener(v -> showTimePickerDialog());

        Button buttonAddTask = findViewById(R.id.buttonAddTask);
        buttonAddTask.setOnClickListener(v -> {
            String title = editTextTaskTitle.getText().toString();
            String description = editTextTaskDescription.getText().toString();
            String dueDate = editTextDueDate.getText().toString();
            String time = editTextTime.getText().toString();
            String priority = spinnerPriority.getSelectedItem().toString();

            if (!title.isEmpty() && !description.isEmpty() && !dueDate.isEmpty() && !time.isEmpty()) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("new_task", title + " - " + description + " - " + dueDate + " " + time + " - " + priority);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            } else {
                Toast.makeText(AddTaskActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                (view, year1, month1, dayOfMonth) -> editTextDueDate.setText(dayOfMonth + "/" + (month1 + 1) + "/" + year1),
                year, month, day);
        datePickerDialog.show();
    }

    private void showTimePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                (view, hourOfDay, minuteOfHour) -> editTextTime.setText(String.format("%02d:%02d", hourOfDay, minuteOfHour)),
                hour, minute, true);
        timePickerDialog.show();
    }
}
