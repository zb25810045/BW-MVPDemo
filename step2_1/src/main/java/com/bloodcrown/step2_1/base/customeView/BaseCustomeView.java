package com.bloodcrown.step2_1.base.customeView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.View;

import com.bloodcrown.step2_1.base.base.IBaseView;

/**
 * Created by zbzbgo on 2017/12/3.
 */

public abstract class BaseCustomeView<V extends BaseCustomeView, P extends BaseCustomeViewPersenter<V>> extends AppCompatButton implements IBaseView {

    private P mBasePersenter;
    private onCustomeClickListener customeClickListener;

    private ICustomeViewLifecycleProxy lifecycleProxy;

    protected abstract P createPersenter();

    public P getPersenter() {
        return mBasePersenter;
    }

    public BaseCustomeView(Context context) {
        super(context);
        init();
    }

    public BaseCustomeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BaseCustomeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        mBasePersenter = createPersenter();
        mBasePersenter.attachView((V) this);

        lifecycleProxy = getPersenter().createlLifecycleProxy();
        //        lifecycleProxy = (ICustomeViewLifecycleProxy) Proxy.newProxyInstance(lifecycleProxy.getClass().getClassLoader(), lifecycleProxy.getClass().getInterfaces(), new NotNullnvocationHandler(lifecycleProxy));
    }

    public void setCustomeClickListener(onCustomeClickListener customeClickListener) {
        this.customeClickListener = customeClickListener;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        lifecycleProxy.onFinishInflate();
    }

    @Override
    public void setOnClickListener(@Nullable final OnClickListener l) {

        super.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (customeClickListener != null) {
                    customeClickListener.onCustomeClick(v);
                }
                lifecycleProxy.onClickListener();
                l.onClick(v);
            }
        });
    }

    @Override
    protected void onDetachedFromWindow() {
        if (mBasePersenter != null) {
            mBasePersenter.detachView();
        }
        super.onDetachedFromWindow();
    }

    public interface onCustomeClickListener {

        void onCustomeClick(View view);

    }

}
