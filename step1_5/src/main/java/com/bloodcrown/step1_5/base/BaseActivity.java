package com.bloodcrown.step1_5.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by zbzbgo on 2017/11/26.
 */

public abstract class BaseActivity<V extends IBaseView, P extends BasePersenter<V>> extends AppCompatActivity implements IBaseView {

    public P mBasePersenter;

    protected abstract P createPersenter();

    public P getPersenter() {
        if (mBasePersenter == null) {
            mBasePersenter = createPersenter();
        }
        return mBasePersenter;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBasePersenter = createPersenter();
        mBasePersenter.attachView((V) this);
    }

    @Override
    protected void onDestroy() {
        if (mBasePersenter != null) {
            mBasePersenter.detachView();
        }
        super.onDestroy();
    }
}
