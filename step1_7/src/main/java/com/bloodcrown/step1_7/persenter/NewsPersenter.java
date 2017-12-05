package com.bloodcrown.step1_7.persenter;

import com.bloodcrown.step1_7.base.BasePersenter;
import com.bloodcrown.step1_7.modle.NewsModle;
import com.bloodcrown.step1_7.ui.INewsView;

/**
 * Created by zbzbgo on 2017/11/25.
 */

public class NewsPersenter extends BasePersenter<INewsView> {

    private NewsModle mNewsModle;

    public NewsPersenter() {
        mNewsModle = new NewsModle();
    }

    public void update() {
        if (mNewsModle == null) {
            return;
        }
        getView().update(mNewsModle.getNews());
    }

}
