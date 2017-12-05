package com.bloodcrown.step1_7.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import com.bloodcrown.step1_7.base.BaseCustomeView;
import com.bloodcrown.step1_7.persenter.NewsPersenter;

/**
 * Created by zbzbgo on 2017/12/3.
 */

public class NewsButton extends BaseCustomeView<INewsView, NewsPersenter> implements INewsView {

    public NewsButton(Context context) {
        super(context);
    }

    public NewsButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NewsButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void showNewsList() {

    }

    @Override
    protected NewsPersenter createPersenter() {
        return new NewsPersenter();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NewsButton.this.getContext(), "自定义 view 激活", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
