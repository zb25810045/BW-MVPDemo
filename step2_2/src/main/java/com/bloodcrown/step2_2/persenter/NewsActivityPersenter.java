package com.bloodcrown.step2_2.persenter;

import android.os.Bundle;
import android.util.Log;

import com.bloodcrown.step2_2.base.activity.BaseActivityPersenter;
import com.bloodcrown.step2_2.modle.NewsModle;
import com.bloodcrown.step2_2.ui.NewsActivity;

/**
 * Created by zbzbgo on 2017/11/25.
 */

public class NewsActivityPersenter extends BaseActivityPersenter<NewsActivity> {

    private NewsModle mNewsModle;

    public NewsActivityPersenter() {
        mNewsModle = new NewsModle();
    }

    public void update() {
        if (mNewsModle == null) {
            return;
        }
        getView().update(mNewsModle.getNews());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("AAA", "...onCreate...NewsActivityPersenter");
    }
}
