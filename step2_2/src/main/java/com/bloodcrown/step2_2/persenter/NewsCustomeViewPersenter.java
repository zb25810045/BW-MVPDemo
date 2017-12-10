package com.bloodcrown.step2_2.persenter;

import android.util.Log;

import com.bloodcrown.step2_2.base.customeView.BaseCustomeViewPersenter;
import com.bloodcrown.step2_2.modle.NewsModle;
import com.bloodcrown.step2_2.ui.NewsButton;

/**
 * Created by zbzbgo on 2017/11/25.
 */

public class NewsCustomeViewPersenter extends BaseCustomeViewPersenter<NewsButton> {

    private NewsModle mNewsModle;

    public NewsCustomeViewPersenter() {
        mNewsModle = new NewsModle();
    }

    public void update() {
        if (mNewsModle == null) {
            return;
        }
        getView().update(mNewsModle.getNews());
    }

    @Override
    public void onFinishInflate() {
        Log.d("AAA", "...onFinishInflate...NewsCustomeViewPersenter");
    }

    @Override
    public void onClickListener() {
        Log.d("AAA", "...onClickListener...NewsCustomeViewPersenter");
    }
}
