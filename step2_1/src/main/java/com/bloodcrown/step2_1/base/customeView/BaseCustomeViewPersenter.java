package com.bloodcrown.step2_1.base.customeView;

import com.bloodcrown.step2_1.base.base.BasePersenter;

/**
 * Created by zbzbgo on 2017/12/8.
 */

public class BaseCustomeViewPersenter<V extends BaseCustomeView> extends BasePersenter<V,ICustomeViewLifecycleProxy> implements ICustomeViewLifecycleProxy {

    @Override
    protected ICustomeViewLifecycleProxy createlLifecycleProxy() {
        return this;
    }

    @Override
    public void onFinishInflate() {

    }

    @Override
    public void onClickListener() {

    }

    @Override
    public void onDetachedFromWindow() {

    }
}
