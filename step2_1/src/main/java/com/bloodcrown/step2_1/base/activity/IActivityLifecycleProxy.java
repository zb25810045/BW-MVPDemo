package com.bloodcrown.step2_1.base.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.bloodcrown.step2_1.base.base.ILifecycleProxy;

/**
 * Created by zbzbgo on 2017/12/8.
 */

public interface IActivityLifecycleProxy extends ILifecycleProxy {

    void onCreate(Bundle savedInstanceState);

    void onPause();

    void onResume();

    void onStop();

    void onStart();

    void onRestart();

    void onNewIntent(Intent intent);

    void onSaveInstanceState(Bundle outState);

    /**
     *
     * @return 返回true 表示需要单独处理返回键监听，不需要系统监听了
     */
    boolean onBackPressed();

    void onActivityResult(int requestCode, int resultCode, Intent data);

    void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults);

    void onDestroy();

}
