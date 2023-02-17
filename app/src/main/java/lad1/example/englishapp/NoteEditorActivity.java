package lad1.example.englishapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.HashSet;

public class NoteEditorActivity extends AppCompatActivity {

    int noteID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);

        ImageView imgDone = findViewById(R.id.imgDone);
        imgDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        EditText edtNote = findViewById(R.id.edtNote);

        Intent intent = getIntent();
        noteID = intent.getIntExtra("noteID",-1);

        if (noteID != -1) {
            edtNote.setText(NoteFragment.notes.get(noteID));
        }else{
            NoteFragment.notes.add("");
            noteID = NoteFragment.notes.size()-1;
            NoteFragment.arrayAdapter.notifyDataSetChanged();
        }

        edtNote.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                NoteFragment.notes.set(noteID, String.valueOf(s));
                NoteFragment.arrayAdapter.notifyDataSetChanged();

                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("lad1.example.englishapp", Context.MODE_PRIVATE);
                HashSet<String> set = new HashSet(NoteFragment.notes);
                sharedPreferences.edit().putStringSet("note", set).apply();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}