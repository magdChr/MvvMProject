package com.magdaproject.mvvmproject.ui.controlls;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.magdaproject.mvvmproject.R;
import com.magdaproject.mvvmproject.model.Note;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {
    List<Note> allNotes = new ArrayList<>();

    public NoteAdapter() {

    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new NoteViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note currentNote = allNotes.get(position);
        holder.title.setText(currentNote.getTitle());
        holder.description.setText(currentNote.getDescriotion());
        holder.priority.setText(String.valueOf(currentNote.getPriority()));
    }

    public void setNotes(List<Note> notes){
        this.allNotes = notes;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return allNotes.size();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView description;
        private TextView priority;

        public NoteViewHolder(@NonNull View itemView) {//itemView is the parent view of the layout loaded in this holder
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            priority = itemView.findViewById(R.id.priority);
        }
    }
}
