package com.bloodcrown.step2_2.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.bloodcrown.step2_2.R;
import com.bloodcrown.step2_2.base.fragment.BaseFragment;
import com.bloodcrown.step2_2.persenter.NewsFragmentPersenter;

/**
 * Created by zbzbgo on 2017/12/3.
 */

public class NewsFragment extends BaseFragment<NewsFragment, NewsFragmentPersenter> implements INewsView {

    private TextView tx_content;
    private Button btn_getNews;

    private Button btn_content;
    private Button btn_loading;
    private Button btn_dataError;
    private Button btn_dataEmpty;
    private Button btn_netError;

    private FrameLayout layout_content;

    @Override
    public void update(String data) {

    }

    @Override
    public void showNewsList() {
        tx_content.setText("fragment...fragment...fragment");
    }

    @Override
    protected NewsFragmentPersenter createPersenter() {
        return new NewsFragmentPersenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_news, container, false);
        }
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        layout_content = (FrameLayout) rootView.findViewById(R.id.layout_content);

        tx_content = (TextView) rootView.findViewById(R.id.content);
        btn_getNews = (Button) rootView.findViewById(R.id.title11);

        btn_content = (Button) rootView.findViewById(R.id.title31);
        btn_loading = (Button) rootView.findViewById(R.id.title24);
        btn_dataError = (Button) rootView.findViewById(R.id.title22);
        btn_dataEmpty = (Button) rootView.findViewById(R.id.title23);
        btn_netError = (Button) rootView.findViewById(R.id.title21);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // 自由设定状态页面加载的父布局
        getStateView().setRootView(layout_content);

        btn_getNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPersenter().update();
                getPersenter().getView().showNewsList();
            }
        });

        btn_loading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsFragment.this.showLoading();
            }
        });

        btn_dataError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsFragment.this.showDataError();
            }
        });

        btn_dataEmpty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsFragment.this.showDataEmpty();
            }
        });

        btn_netError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsFragment.this.shownNetError();
            }
        });

        btn_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsFragment.this.showContent();
            }
        });
    }
}
