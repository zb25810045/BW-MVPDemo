package com.bloodcrown.step2_2.base.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bloodcrown.step2_2.base.base.ILifecycleProxy;

/**
 * Created by zbzbgo on 2017/12/8.
 */

public interface IFragmentLifecycleProxy extends ILifecycleProxy {

    void onAttach(Context context);

    void onCreate(@Nullable Bundle savedInstanceState);

    void onStart();

    void onResume();

    View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    void onViewCreated(View view, @Nullable Bundle savedInstanceState);

    void onActivityCreated(@Nullable Bundle savedInstanceState);

    void onPause();

    void onStop();

    void onActivityResult(int requestCode, int resultCode, Intent data);

    void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults);

    void onSaveInstanceState(Bundle outState);

    void onDestroyView();

    void onDestroy();

}
