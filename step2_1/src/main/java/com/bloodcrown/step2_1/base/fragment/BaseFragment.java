package com.bloodcrown.step2_1.base.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bloodcrown.step2_1.base.base.IBaseView;

/**
 * Created by zbzbgo on 2017/12/3.
 */

public abstract class BaseFragment<V extends BaseFragment, P extends BaseFragmentPersenter<V>> extends Fragment implements IBaseView {

    private P mBasePersenter;

    protected abstract P createPersenter();

    private IFragmentLifecycleProxy lifecycleProxy;

    public P getPersenter() {
        return mBasePersenter;
    }

    @Override
    public void onAttach(Context context) {
//        lifecycleProxy.onAttach(context);
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBasePersenter = createPersenter();
        mBasePersenter.attachView((V) this);

        lifecycleProxy = getPersenter().createlLifecycleProxy();
//        lifecycleProxy = (IFragmentLifecycleProxy) Proxy.newProxyInstance(lifecycleProxy.getClass().getClassLoader(), lifecycleProxy.getClass().getInterfaces(), new NotNullnvocationHandler(lifecycleProxy));

        lifecycleProxy.onCreate(savedInstanceState);
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
        View view = lifecycleProxy.onCreateView(inflater, container, savedInstanceState);
        if (view != null) {
            return view;
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        lifecycleProxy.onViewCreated(view, savedInstanceState);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        lifecycleProxy.onActivityCreated(savedInstanceState);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onPause() {
        lifecycleProxy.onPause();
        super.onPause();
    }

    @Override
    public void onStop() {
        lifecycleProxy.onStop();
        super.onStop();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        lifecycleProxy.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        lifecycleProxy.onRequestPermissionsResult(requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        lifecycleProxy.onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
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

}
