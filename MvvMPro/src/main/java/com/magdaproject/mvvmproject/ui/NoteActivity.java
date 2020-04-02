package com.magdaproject.mvvmproject.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.magdaproject.mvvmproject.R;
import com.magdaproject.mvvmproject.databinding.ActivityNoteBinding;
import com.magdaproject.mvvmproject.model.Note;
import com.magdaproject.mvvmproject.ui.controlls.NoteAdapter;
import com.magdaproject.mvvmproject.viewmodel.NoteViewModel;

import java.util.List;

public class NoteActivity extends AppCompatActivity {

    private NoteViewModel noteViewModel;
    ActivityNoteBinding activityNoteBinding;
    RecyclerView noteRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        //activityNoteBinding =
        noteRecycler = findViewById(R.id.note_recycler);
        noteRecycler.setLayoutManager(new LinearLayoutManager(this));
        noteRecycler.setHasFixedSize(true);
        final NoteAdapter noteAdapter = new NoteAdapter();
        noteRecycler.setAdapter(noteAdapter);

        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                noteAdapter.setNotes(notes);

            }
        });
    }
}
