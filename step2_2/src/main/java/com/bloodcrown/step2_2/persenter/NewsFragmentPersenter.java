package com.bloodcrown.step2_2.persenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.bloodcrown.step2_2.base.fragment.BaseFragmentPersenter;
import com.bloodcrown.step2_2.modle.NewsModle;
import com.bloodcrown.step2_2.ui.NewsFragment;

/**
 * Created by zbzbgo on 2017/11/25.
 */

public class NewsFragmentPersenter extends BaseFragmentPersenter<NewsFragment> {

    private NewsModle mNewsModle;

    public NewsFragmentPersenter() {
        mNewsModle = new NewsModle();
    }

    public void update() {
        if (mNewsModle == null) {
            return;
        }
        getView().update(mNewsModle.getNews());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("AAA", "...onCreate...NewsFragmentPersenter");
    }
}
