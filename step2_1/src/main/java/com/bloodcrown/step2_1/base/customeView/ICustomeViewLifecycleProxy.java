package com.bloodcrown.step2_1.base.customeView;

import com.bloodcrown.step2_1.base.base.ILifecycleProxy;

/**
 * Created by zbzbgo on 2017/12/8.
 */

public interface ICustomeViewLifecycleProxy extends ILifecycleProxy {

    void onFinishInflate();

    void onClickListener();

    void onDetachedFromWindow();
}
