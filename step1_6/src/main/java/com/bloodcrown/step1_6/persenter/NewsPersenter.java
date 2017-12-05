package com.bloodcrown.step1_6.persenter;

import com.bloodcrown.step1_6.base.BasePersenter;
import com.bloodcrown.step1_6.modle.NewsModle;
import com.bloodcrown.step1_6.ui.INewsView;

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
