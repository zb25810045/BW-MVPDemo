package com.bloodcrown.step2_2.base.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.bloodcrown.step2_2.base.base.IBaseView;
import com.bloodcrown.step2_2.stateview.DefaultStateView;

/**
 * Created by zbzbgo on 2017/11/26.
 */

public abstract class BaseActivity<V extends BaseActivity, P extends BaseActivityPersenter<V>> extends AppCompatActivity implements IBaseView {

    private P mBasePersenter;

    protected abstract P createPersenter();

    protected DefaultStateView mStateView;

    private IActivityLifecycleProxy lifecycleProxy;

    public P getPersenter() {
        return mBasePersenter;
    }

    @Override
    public DefaultStateView getStateView() {
        if (mStateView == null) {
            initStateView();
        }
        return mStateView;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();
        lifecycleProxy.onCreate(savedInstanceState);
    }

    public void init() {
        initPersenter();
        initStateView();
        initLifecycleProxy();
    }

    public void initLifecycleProxy() {
        lifecycleProxy = getPersenter().createlLifecycleProxy();
    }

    public void initPersenter() {
        mBasePersenter = createPersenter();
        mBasePersenter.attachView((V) this);
    }

    public void initStateView() {
        mStateView = createStateView();
        mStateView.setRootView((ViewGroup) getWindow().getDecorView());
    }

    public DefaultStateView createStateView() {
        return new DefaultStateView(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        lifecycleProxy.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        lifecycleProxy.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        lifecycleProxy.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        lifecycleProxy.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        lifecycleProxy.onStart();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        lifecycleProxy.onNewIntent(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        lifecycleProxy.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        if (lifecycleProxy.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        lifecycleProxy.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        lifecycleProxy.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        lifecycleProxy.onDestroy();

        if (mBasePersenter != null) {
            mBasePersenter.detachView();
        }
        super.onDestroy();
    }

    @Override
    public void showContent() {
        getStateView().showContent();
    }

    @Override
    public void showDataError() {
        getStateView().showDataError();
    }

    @Override
    public void showDataEmpty() {
        getStateView().showDataEmpty();
    }

    @Override
    public void shownNetError() {
        getStateView().shownNetError();
    }

    @Override
    public void showLoading() {
        getStateView().showLoading();
    }

}
