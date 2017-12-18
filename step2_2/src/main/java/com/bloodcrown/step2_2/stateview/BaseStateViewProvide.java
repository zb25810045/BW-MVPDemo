package com.bloodcrown.step2_2.stateview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zbzbgo on 2017/12/16.
 */

public abstract class BaseStateViewProvide implements IStateViewProvide {

    protected Context context;

    protected int curState = StateCodes.CONTENT.code;
    protected Map<Integer, Integer> stateIDs;
    protected Map<Integer, View> stateViews;

    public BaseStateViewProvide(Context context) {
        this.context = context;
        init();
    }

    @Override
    public void setContext(Context context) {
        this.context = context;
    }

    public int getCurState() {
        return curState;
    }

    public Map<Integer, Integer> getStateIDs() {
        if (stateIDs == null) {
            initMap();
        }
        return stateIDs;
    }

    public Map<Integer, View> getStateViews() {
        if (stateViews == null) {
            initMap();
        }
        return stateViews;
    }

    public View getStateView(int stateViewCode) {

        if (stateViews == null) {
            init();
        }
        if (stateViews == null || stateViews.size() == 0) {
            return null;
        }
        return stateViews.get(stateViewCode);
    }

    public int getStateViewID(int stateViewCode) {

        if (stateIDs == null) {
            init();
        }
        if (stateIDs == null || stateIDs.size() == 0) {
            return 0;
        }
        return stateIDs.get(stateViewCode);
    }

    public View inflateView(int stateViewCode) {

        if (context == null) {
            return null;
        }
        int stateViewCode2 = stateViewCode;
        Integer integer = getStateIDs().get(stateViewCode);
        View view = LayoutInflater.from(context).inflate(integer, null, false);

        if (view == null) {
            return null;
        }

        getStateViews().put(stateViewCode, view);
        return view;
    }

    private void init() {
        initMap();
        initData();
    }

    private void initMap() {
        if (stateIDs == null) {
            stateIDs = new HashMap<>();
        }
        if (stateViews == null) {
            stateViews = new HashMap<>();
        }
    }

    protected abstract void initData();

    protected void invalidateData() {
        if (stateViews == null || stateIDs == null) {
            initMap();
        }
        stateViews.clear();
        stateIDs.clear();
        initData();
    }

    protected void setStateVIewIDAndCleanStateView(int stateVIewCode,int stateVIewID) {
        getStateIDs().remove(stateVIewCode);
        getStateIDs().put(stateVIewCode, stateVIewID);
        getStateViews().remove(stateVIewCode);
    }


}
