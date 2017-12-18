package com.bloodcrown.step2_2.stateview;

import android.content.Context;
import android.view.View;

import com.bloodcrown.step2_2.R;

/**
 * Created by zbzbgo on 2017/12/16.
 */

public class DefaultStateViewProvide extends BaseStateViewProvide {

    public DefaultStateViewProvide(Context context) {
        super(context);
    }

    @Override
    protected void initData() {
        getStateIDs().put(StateCodes.LOADING.code, R.layout.layout_stateview_loading);
        getStateIDs().put(StateCodes.DATA_ERROR.code, R.layout.layout_stateview_dataerror);
        getStateIDs().put(StateCodes.DATA_EMPTY.code, R.layout.layout_stateview_dataempty);
        getStateIDs().put(StateCodes.NET_ERROR.code, R.layout.layout_stateview_neterror);
    }

    public void setmDataErrorViewID(int mDataErrorViewID) {
        setStateVIewIDAndCleanStateView(StateCodes.DATA_ERROR.code, mDataErrorViewID);
    }

    public void setmDataEmptyViewID(int mDataEmptyViewID) {
        setStateVIewIDAndCleanStateView(StateCodes.DATA_EMPTY.code, mDataEmptyViewID);
    }

    public void setmNetErrorViewID(int mNetErrorViewID) {
        setStateVIewIDAndCleanStateView(StateCodes.NET_ERROR.code, mNetErrorViewID);
    }

    public void setmloadingViewID(int mLoadingViewID) {
        setStateVIewIDAndCleanStateView(StateCodes.LOADING.code, mLoadingViewID);
    }

    @Override
    public View getCurrentStateView() {
        return getStateViews().get(curState);
    }

    @Override
    public int getCurrentStateViewCode() {
        return curState;
    }

    @Override
    public void setCurrentStateViewCode(int stateViewCode) {
        curState = stateViewCode;
    }

    @Override
    public View getStateViewByCode(int stateViewCode) {

        View view = getStateViews().get(stateViewCode);
        if (view == null) {
            view = inflateView(stateViewCode);
        }

        return view;
    }

}
