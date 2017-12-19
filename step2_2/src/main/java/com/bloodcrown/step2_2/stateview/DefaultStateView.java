package com.bloodcrown.step2_2.stateview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zbzbgo on 2017/12/16.
 */

public class DefaultStateView implements IStateView {

    public Context context;

    private ViewGroup rootView;
    private IStateViewProvide mStateViewProvide;

    public DefaultStateView(Context context) {
        this.context = context;
        init();
    }

    private void init() {
        initStateViewProvide(context);
    }

    private void initStateViewProvide(Context context) {
        mStateViewProvide = new DefaultStateViewProvide(context);
    }

    public IStateViewProvide getStateViewProvide() {
        return mStateViewProvide;
    }

    public void setContext(Context context) {
        this.context = context;
        invalidata(context);
    }

    @Override
    public void showContent() {
        if (rootView == null) {
            return;
        }
        if (StateCodes.CONTENT.code != mStateViewProvide.getCurrentStateViewCode()) {
            cleanCurrentStateView();
        }
    }

    @Override
    public void showDataError() {
        if (rootView == null) {
            return;
        }
        if (StateCodes.DATA_ERROR.code != mStateViewProvide.getCurrentStateViewCode()) {
            addDataErrorStateView();
        }
    }

    @Override
    public void showDataEmpty() {
        if (rootView == null) {
            return;
        }
        if (StateCodes.DATA_EMPTY.code != mStateViewProvide.getCurrentStateViewCode()) {
            addDataEmptyStateView();
        }
    }

    @Override
    public void shownNetError() {
        if (rootView == null) {
            return;
        }
        if (StateCodes.NET_ERROR.code != mStateViewProvide.getCurrentStateViewCode()) {
            addNetErrorStateView();
        }
    }

    @Override
    public void showLoading() {
        if (rootView == null) {
            return;
        }
        if (StateCodes.LOADING.code != mStateViewProvide.getCurrentStateViewCode()) {
            addloaingStateView();
        }
    }

    public void cleanCurrentStateView() {

        View currentStateView = mStateViewProvide.getCurrentStateView();
        if (currentStateView == null || rootView == null) {
            return;
        }
        rootView.removeView(currentStateView);
        mStateViewProvide.setCurrentStateViewCode(StateCodes.CONTENT.code);
    }

    public void setRootView(ViewGroup rootView) {
        this.rootView = rootView;
    }

    private void addDataErrorStateView() {
        cleanCurrentStateView();
        addStateViewByStateViewCode(StateCodes.DATA_ERROR.code);
    }

    private void addDataEmptyStateView() {
        cleanCurrentStateView();
        addStateViewByStateViewCode(StateCodes.DATA_EMPTY.code);
    }

    private void addNetErrorStateView() {
        cleanCurrentStateView();
        addStateViewByStateViewCode(StateCodes.NET_ERROR.code);
    }

    private void addloaingStateView() {
        cleanCurrentStateView();
        addStateViewByStateViewCode(StateCodes.LOADING.code);
    }

    private void addStateViewByStateViewCode(int stateViewCode) {
        View view = mStateViewProvide.getStateViewByCode(stateViewCode);
        if (view == null || rootView == null) {
            return;
        }
        rootView.addView(view);
        mStateViewProvide.setCurrentStateViewCode(stateViewCode);
    }

    private void invalidata(Context context) {
        if (context == null) {
            return;
        }
        mStateViewProvide = new DefaultStateViewProvide(context);
    }

}
