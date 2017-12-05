package com.bloodcrown.step1_1.persenter;

import com.bloodcrown.step1_1.modle.NewsModle;
import com.bloodcrown.step1_1.ui.IBaseView;

/**
 * Created by zbzbgo on 2017/11/25.
 */

public class NewsPersenter {

    private IBaseView mIBaseView;
    private NewsModle mNewsModle;

    public NewsPersenter() {
        mNewsModle = new NewsModle();
    }

    public void setmIBaseView(IBaseView baseViewa) {
        this.mIBaseView = baseViewa;
    }

    public void update() {
        if (mNewsModle == null || mIBaseView == null) {
            return;
        }
        mIBaseView.update(mNewsModle.getNews());
    }

}
