package com.bloodcrown.step1_7.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bloodcrown.step1_7.R;
import com.bloodcrown.step1_7.base.BaseActivity;
import com.bloodcrown.step1_7.persenter.NewsPersenter;

public class NewsActivity extends BaseActivity<INewsView, NewsPersenter> implements INewsView {

    private TextView tx_content;
    private Button btn_getNews;
    private Button btn_satrtFragment;

    @Override
    protected NewsPersenter createPersenter() {
        return new NewsPersenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tx_content = (TextView) findViewById(R.id.content);
        btn_getNews = (Button) findViewById(R.id.title);
        btn_satrtFragment = (Button) findViewById(R.id.title2);

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
    }

    @Override
    public void update(String data) {
        tx_content.setText(data);
    }

    @Override
    public void showNewsList() {
    }
}
