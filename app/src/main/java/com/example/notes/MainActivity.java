package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button saveBtn;
    private SharedPreferences myNote;
    private static String NOTE_TEXT = "note_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inIt();
        getData();
    }

    private void inIt() {
        editText = findViewById(R.id.editText);
        saveBtn = findViewById(R.id.saveBtn);
        myNote = getSharedPreferences("My note", MODE_PRIVATE);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = myNote.edit();
                String note = editText.getText().toString();
                editor.putString(NOTE_TEXT, note);
                editor.apply();
                Toast.makeText(MainActivity.this, "Заметка сохранена", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getData() {
        String note = myNote.getString(NOTE_TEXT, "");
        editText.setText(note);
    }
}