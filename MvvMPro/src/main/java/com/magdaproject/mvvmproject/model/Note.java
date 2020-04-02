package com.magdaproject.mvvmproject.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")//if did not have this, name of the table woulb be note
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;

    private String descriotion;
    @ColumnInfo(name = "priority_column")
    private int priority;


    public Note(String title, String descriotion, int priority) {
        this.title = title;
        this.descriotion = descriotion;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriotion() {
        return descriotion;
    }

 
    public void setNDescription(String descriotion) {
        this.descriotion = descriotion;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }


}
