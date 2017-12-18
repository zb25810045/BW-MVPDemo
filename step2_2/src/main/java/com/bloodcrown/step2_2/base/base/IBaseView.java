package com.bloodcrown.step2_2.base.base;

import com.bloodcrown.step2_2.stateview.DefaultStateView;
import com.bloodcrown.step2_2.stateview.IStateView;

/**
 * Created by zbzbgo on 2017/11/25.
 */

public interface IBaseView extends IStateView {

    DefaultStateView getStateView();

}
