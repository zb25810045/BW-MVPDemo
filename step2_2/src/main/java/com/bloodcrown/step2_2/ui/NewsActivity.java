package com.bloodcrown.step2_2.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bloodcrown.step2_2.R;
import com.bloodcrown.step2_2.base.activity.BaseActivity;
import com.bloodcrown.step2_2.base.customeView.BaseCustomeView;
import com.bloodcrown.step2_2.persenter.NewsActivityPersenter;

public class NewsActivity extends BaseActivity<NewsActivity, NewsActivityPersenter> implements INewsView {

    private TextView tx_content;
    private Button btn_getNews;
    private Button btn_satrtFragment;

    private NewsButton btn_news;

    private Button btn_content;
    private Button btn_loading;
    private Button btn_dataError;
    private Button btn_dataEmpty;
    private Button btn_netError;

    private FrameLayout layout_content;

    @Override
    protected NewsActivityPersenter createPersenter() {
        return new NewsActivityPersenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout_content = (FrameLayout) findViewById(R.id.layout_content);

        // 自由设定状态页面加载的父布局
        getStateView().setRootView(layout_content);
        // 自由替换状态页类型
        getStateView().getStateViewProvide().setmloadingViewID(R.layout.layout_stateview_loading_2);

        tx_content = (TextView) findViewById(R.id.content);
        btn_getNews = (Button) findViewById(R.id.title);
        btn_satrtFragment = (Button) findViewById(R.id.title2);

        btn_news = (NewsButton) findViewById(R.id.title3);

        btn_content = (Button) findViewById(R.id.title31);
        btn_loading = (Button) findViewById(R.id.title24);
        btn_dataError = (Button) findViewById(R.id.title22);
        btn_dataEmpty = (Button) findViewById(R.id.title23);
        btn_netError = (Button) findViewById(R.id.title21);

        btn_getNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPersenter().update();
                getPersenter().getView().showNewsList();
            }
        });

        btn_satrtFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.rootView, new NewsFragment(), NewsFragment.class.getSimpleName()).commit();
            }
        });

        btn_news.setCustomeClickListener(new BaseCustomeView.onCustomeClickListener() {
            @Override
            public void onCustomeClick(View view) {
                Log.d("AAA", "...setCustomeClickListener...NewsActivity");
            }
        });

        btn_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NewsActivity.this, "真点击事件", Toast.LENGTH_SHORT).show();
            }
        });

        btn_loading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsActivity.this.showLoading();
            }
        });

        btn_dataError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsActivity.this.showDataError();
            }
        });

        btn_dataEmpty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsActivity.this.showDataEmpty();
            }
        });

        btn_netError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsActivity.this.shownNetError();
            }
        });

        btn_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsActivity.this.showContent();
            }
        });
    }

    @Override
    public void update(String data) {
        tx_content.setText(data);
    }

    @Override
    public void showNewsList() {
    }

}
