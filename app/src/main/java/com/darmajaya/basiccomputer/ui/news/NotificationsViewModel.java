package com.darmajaya.basiccomputer.ui.news;

import android.os.Handler;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.darmajaya.basiccomputer.Model.News;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class NotificationsViewModel extends ViewModel {
    private String TAG = NotificationsViewModel.class.getSimpleName();

    private MutableLiveData<List<News>> newsList;
    private             long data = 1;


    LiveData<List<News>> getNewsList() {
        if (newsList == null) {
            newsList = new MutableLiveData<>();
            loadFruits();
        }
        return newsList;
    }

    private void loadFruits() {
        // do async operation to fetch users
        Handler myHandler = new Handler();
        myHandler.postDelayed(() -> {
            List<News> fruitsStringList = new ArrayList<>();
             fruitsStringList.add(new News(data, "test", "dummy", "koko"));
             fruitsStringList.add(new News(data, "test2", "dummy3", "koko3"));
             fruitsStringList.add(new News(data, "test2", "dummy3", "koko4"));
             fruitsStringList.add(new News(data, "test2", "dummy4", "koko5"));

            long seed = System.nanoTime();
            Collections.shuffle(fruitsStringList, new Random(seed));

            newsList.setValue(fruitsStringList);
        }, 5000);

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "on cleared called");
    }
}