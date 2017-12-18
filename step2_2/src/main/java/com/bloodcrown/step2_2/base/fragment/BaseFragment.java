package com.bloodcrown.step2_2.base.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bloodcrown.step2_2.base.base.IBaseView;
import com.bloodcrown.step2_2.stateview.DefaultStateView;

/**
 * Created by zbzbgo on 2017/12/3.
 */

public abstract class BaseFragment<V extends BaseFragment, P extends BaseFragmentPersenter<V>> extends Fragment implements IBaseView {

    public View rootView;
    private P mBasePersenter;

    protected abstract P createPersenter();

    private IFragmentLifecycleProxy lifecycleProxy;
    private DefaultStateView mStateView;

    public P getPersenter() {
        return mBasePersenter;
    }

    @Override
    public DefaultStateView getStateView() {
        return mStateView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();
        lifecycleProxy.onCreate(savedInstanceState);
    }

    private void init() {
        initPersenter();
        initlifecycleProxy();
        initStateView();
    }

    private void initPersenter() {
        mBasePersenter = createPersenter();
        mBasePersenter.attachView((V) this);
    }

    private void initlifecycleProxy() {
        lifecycleProxy = getPersenter().createlLifecycleProxy();
    }

    private void initStateView() {
        mStateView = createStateView();
    }

    public DefaultStateView createStateView() {
        return new DefaultStateView(getContext());
    }

    @Override
    public void onStart() {
        lifecycleProxy.onStart();
        super.onStart();
    }

    @Override
    public void onResume() {
        lifecycleProxy.onResume();
        super.onResume();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = lifecycleProxy.onCreateView(inflater, container, savedInstanceState);
        if (rootView != null) {
            return rootView;
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lifecycleProxy.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //注意 rootview 的父控件才是我们的目标
        getStateView().setRootView((ViewGroup) rootView.getParent());
        lifecycleProxy.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onPause() {
        super.onPause();
        lifecycleProxy.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        lifecycleProxy.onStop();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        lifecycleProxy.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        lifecycleProxy.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        lifecycleProxy.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroyView() {
        lifecycleProxy.onDestroyView();
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        lifecycleProxy.onDestroy();
        if (mBasePersenter != null) {
            mBasePersenter.detachView();
        }
        super.onDestroy();
    }

    @Override
    public void showContent() {
        mStateView.showContent();
    }

    @Override
    public void showDataError() {
        mStateView.showDataError();
    }

    @Override
    public void showDataEmpty() {
        mStateView.showDataEmpty();
    }

    @Override
    public void shownNetError() {
        mStateView.shownNetError();
    }

    @Override
    public void showLoading() {
        mStateView.showLoading();
    }

}
