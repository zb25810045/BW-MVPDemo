package com.bloodcrown.step1_7.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by zbzbgo on 2017/12/3.
 */

public abstract class BaseFragment<V extends IBaseView, P extends BasePersenter<V>> extends Fragment implements IBaseView {

    private P mBasePersenter;

    protected abstract P createPersenter();

    public P getPersenter() {
        return mBasePersenter;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBasePersenter = createPersenter();
        mBasePersenter.attachView((V) this);
    }

    @Override
    public void onDestroy() {
        if (mBasePersenter != null) {
            mBasePersenter.detachView();
        }
        super.onDestroy();
    }

}
