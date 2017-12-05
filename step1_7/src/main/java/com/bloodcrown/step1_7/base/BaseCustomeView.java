package com.bloodcrown.step1_7.base;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zbzbgo on 2017/12/3.
 */

public abstract class BaseCustomeView<V extends IBaseView, P extends BasePersenter<V>> extends AppCompatButton implements IBaseView {

    private P mBasePersenter;
    private onCustomeClickListener customeClickListener;

    protected abstract P createPersenter();

    public P getPersenter() {
        return mBasePersenter;
    }

    @Override
    public void update(String data) {

    }

    public BaseCustomeView(Context context) {
        super(context);
    }

    public BaseCustomeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseCustomeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setCustomeClickListener(onCustomeClickListener customeClickListener) {
        this.customeClickListener = customeClickListener;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mBasePersenter = createPersenter();
        mBasePersenter.attachView((V) this);
    }

    @Override
    public void setOnClickListener(@Nullable final OnClickListener l) {

        super.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (customeClickListener != null) {
                    customeClickListener.onCustomeClick(v);
                }
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
