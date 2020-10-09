package com.apps.roomnerds.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Posts.class}, version = 1)
public abstract class PostsDatabase extends RoomDatabase {

    private static PostsDatabase instance;

    public abstract PostsDao postsDao();

    public static synchronized PostsDatabase getInstance(Context context) {

        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), PostsDatabase.class, "Posts_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;

    }
}
