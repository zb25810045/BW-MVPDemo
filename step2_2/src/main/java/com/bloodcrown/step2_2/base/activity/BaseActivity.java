package com.bloodcrown.step2_2.base.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bloodcrown.step2_2.base.base.IBaseView;

/**
 * Created by zbzbgo on 2017/11/26.
 */

public abstract class BaseActivity<V extends BaseActivity, P extends BaseActivityPersenter<V>> extends AppCompatActivity implements IBaseView {

    private P mBasePersenter;

    protected abstract P createPersenter();

    private IActivityLifecycleProxy lifecycleProxy;

    public P getPersenter() {
        return mBasePersenter;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBasePersenter = createPersenter();
        mBasePersenter.attachView((V) this);

        lifecycleProxy = getPersenter().createlLifecycleProxy();
//        lifecycleProxy = (IActivityLifecycleProxy) Proxy.newProxyInstance(lifecycleProxy.getClass().getClassLoader(), lifecycleProxy.getClass().getInterfaces(), new NotNullnvocationHandler(lifecycleProxy));

        lifecycleProxy.onCreate(savedInstanceState);
    }

    @Override
    protected void onPause() {
        lifecycleProxy.onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        lifecycleProxy.onResume();
        super.onResume();
    }

    @Override
    protected void onStop() {
        lifecycleProxy.onStop();
        super.onStop();
    }

    @Override
    protected void onStart() {
        lifecycleProxy.onStart();
        super.onStart();
    }

    @Override
    protected void onRestart() {
        lifecycleProxy.onStart();
        super.onRestart();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        lifecycleProxy.onNewIntent(intent);
        super.onNewIntent(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        lifecycleProxy.onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
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
        lifecycleProxy.onRequestPermissionsResult(requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        lifecycleProxy.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        lifecycleProxy.onDestroy();

        if (mBasePersenter != null) {
            mBasePersenter.detachView();
        }
        super.onDestroy();
    }
}
