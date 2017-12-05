package com.bloodcrown.step1_2.persenter;

import com.bloodcrown.step1_2.modle.NewsModle;
import com.bloodcrown.step1_2.ui.IBaseView;

/**
 * Created by zbzbgo on 2017/11/25.
 */

public class NewsPersenter {

    private IBaseView mIBaseView;
    private NewsModle mNewsModle;

    public NewsPersenter() {
        mNewsModle = new NewsModle();
    }

    public void attachView(IBaseView baseViewa) {
        this.mIBaseView = baseViewa;
    }

    public void detachView() {
        this.mIBaseView = null;
    }

    public void update() {
        if (mNewsModle == null || mIBaseView == null) {
            return;
        }
        mIBaseView.update(mNewsModle.getNews());
    }

}
