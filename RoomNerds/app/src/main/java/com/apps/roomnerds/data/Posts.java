package com.apps.roomnerds.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "posts_table")
public class Posts {

    @PrimaryKey(autoGenerate = true)
    int id;


    int userId;
    String title;
    String body;

    public Posts(int userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
