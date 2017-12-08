package com.bloodcrown.step2_1.base.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.bloodcrown.step2_1.base.base.BasePersenter;

/**
 * Created by zbzbgo on 2017/12/8.
 */

public class BaseActivityPersenter<V extends BaseActivity> extends BasePersenter<V, IActivityLifecycleProxy> implements IActivityLifecycleProxy {

    @Override
    protected IActivityLifecycleProxy createlLifecycleProxy() {
        return this;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onNewIntent(Intent intent) {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public boolean onBackPressed() {
        return false;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

    }

    @Override
    public void onDestroy() {

    }
}
