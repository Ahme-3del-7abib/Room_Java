package com.apps.roomnerds.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface PostsDao {

    @Insert
    Completable insert(Posts posts);

    @Query("SELECT * FROM posts_table")
    Single<List<Posts>> getPosts();
}
