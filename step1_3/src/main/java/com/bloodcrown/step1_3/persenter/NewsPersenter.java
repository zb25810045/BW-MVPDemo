package com.bloodcrown.step1_3.persenter;

import com.bloodcrown.step1_3.modle.NewsModle;
import com.bloodcrown.step1_3.ui.IBaseView;

/**
 * Created by zbzbgo on 2017/11/25.
 */

public class NewsPersenter extends BasePersenter<IBaseView> {

    private NewsModle mNewsModle;

    public NewsPersenter() {
        mNewsModle = new NewsModle();
    }

    public void update() {
        if (mNewsModle == null || mIBaseView == null) {
            return;
        }
        mIBaseView.update(mNewsModle.getNews());
    }

}
