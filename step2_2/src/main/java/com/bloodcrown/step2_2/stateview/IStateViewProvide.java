package com.bloodcrown.step2_2.stateview;

import android.content.Context;
import android.view.View;

/**
 * Created by zbzbgo on 2017/12/16.
 */

public interface IStateViewProvide {

    void setContext(Context context);

    void setmDataErrorViewID(int mDataErrorViewID);

    void setmDataEmptyViewID(int mDataEmptyViewID);

    void setmNetErrorViewID(int mNetErrorViewID);

    void setmloadingViewID(int mLoadingViewID);

    View getCurrentStateView();

    int getCurrentStateViewCode();

    void setCurrentStateViewCode(int stateViewCode);

    View getStateViewByCode(int stateViewCode);

}
