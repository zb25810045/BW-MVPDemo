package com.bloodcrown.step2_2.base.base;

/**
 * Created by zbzbgo on 2017/11/25.
 */

public abstract class BasePersenter<V extends IBaseView, L extends ILifecycleProxy> {

    protected V mIBaseView;

    protected abstract L createlLifecycleProxy();

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
