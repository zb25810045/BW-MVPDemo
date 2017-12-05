package com.bloodcrown.step1_3.persenter;

import com.bloodcrown.step1_3.ui.IBaseView;

/**
 * Created by zbzbgo on 2017/11/25.
 */

public abstract class BasePersenter<V extends IBaseView> {

    protected V mIBaseView;

    public void attachView(V baseViewa) {
        this.mIBaseView = baseViewa;
    }

    public V getView() {
        return mIBaseView;
    }

    public void detachView() {
        this.mIBaseView = null;
    }

}
