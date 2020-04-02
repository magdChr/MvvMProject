package com.magdaproject.mvvmproject.repository;

import android.content.Context;
import android.os.AsyncTask;

import com.magdaproject.mvvmproject.model.Note;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Note.class},version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    private  static NoteDatabase sInstance;

    public abstract NoteDao noteDao();//Room creates each DAO implementation at compile time


    public static synchronized NoteDatabase getInstance(Context context){
        if(sInstance == null){
            sInstance = Room.databaseBuilder(context.getApplicationContext(),
                    NoteDatabase.class,"note_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }return  sInstance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new populateDbAsyncTask(sInstance).execute();
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };

    private static class populateDbAsyncTask extends AsyncTask<Void, Void, Void>{
        private NoteDao mNoteDao;

        private populateDbAsyncTask(NoteDatabase db){
            mNoteDao = db.noteDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            mNoteDao.insertMore(new Note("TITLE1", "DESC1",1 ),new Note("TITLE2", "DESC2",2 ));
            return null;
        }
    }
}


