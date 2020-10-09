package com.apps.roomnerds.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.apps.roomnerds.R;
import com.apps.roomnerds.data.Posts;
import com.apps.roomnerds.data.PostsDatabase;
import com.apps.roomnerds.databinding.ActivityMainBinding;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    PostsAdapter postsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        postsAdapter = new PostsAdapter();
        binding.postsRecyclerView.setAdapter(postsAdapter);

        final PostsDatabase database = PostsDatabase.getInstance(this);

        binding.insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.postsDao().insert(new Posts(
                        1, binding.editTexttitle.getText().toString(),
                        binding.editTextBody.getText().toString()))
                        .subscribeOn(Schedulers.computation())
                        .subscribe(new CompletableObserver() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onComplete() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }
                        });
            }
        });
        
        binding.getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.postsDao().getPosts()
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new SingleObserver<List<Posts>>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onSuccess(List<Posts> posts) {
                                postsAdapter.setList(posts);
                                postsAdapter.notifyDataSetChanged();
                            }

                            @Override
                            public void onError(Throwable e) {

                            }
                        });

            }
        });


    }
}

