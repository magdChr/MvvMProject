package com.magdaproject.mvvmproject.repository;

import com.magdaproject.mvvmproject.model.Note;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface NoteDao {

    @Insert
    void insert(Note note);

    @Insert
    void insertMore(Note... notes);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);

    @Query("DELETE FROM note_table")
    void deleteAll();

    @Query("SELECT * FROM note_table ORDER BY priority_column DESC")
    LiveData<List<Note>> getAllNotes();/*At compile time room checks if the returned data
    fit the return type(Note) and if not it gives a compile time error*/
}
