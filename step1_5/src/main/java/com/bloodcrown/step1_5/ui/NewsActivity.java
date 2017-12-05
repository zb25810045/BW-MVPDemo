package com.bloodcrown.step1_5.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bloodcrown.step1_5.R;
import com.bloodcrown.step1_5.base.BaseActivity;
import com.bloodcrown.step1_5.persenter.NewsPersenter;

public class NewsActivity extends BaseActivity<INewsView, NewsPersenter> implements INewsView {

    private TextView tx_content;
    private Button btn_getNews;

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

        btn_getNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getPersenter() != null) {
                    getPersenter().update();
                }
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
