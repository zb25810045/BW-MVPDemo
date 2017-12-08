package com.bloodcrown.step2_1.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bloodcrown.step2_1.R;
import com.bloodcrown.step2_1.base.activity.BaseActivity;
import com.bloodcrown.step2_1.base.customeView.BaseCustomeView;
import com.bloodcrown.step2_1.persenter.NewsActivityPersenter;

public class NewsActivity extends BaseActivity<NewsActivity, NewsActivityPersenter> implements INewsView {

    private TextView tx_content;
    private Button btn_getNews;
    private Button btn_satrtFragment;
    private NewsButton btn_news;

    @Override
    protected NewsActivityPersenter createPersenter() {
        return new NewsActivityPersenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tx_content = (TextView) findViewById(R.id.content);
        btn_getNews = (Button) findViewById(R.id.title);
        btn_satrtFragment = (Button) findViewById(R.id.title2);
        btn_news = (NewsButton) findViewById(R.id.title3);

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
                getSupportFragmentManager().beginTransaction().replace(R.id.rootView,new NewsFragment(), NewsFragment.class.getSimpleName()).commit();
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

    }

    @Override
    public void update(String data) {
        tx_content.setText(data);
    }

    @Override
    public void showNewsList() {
    }
}
