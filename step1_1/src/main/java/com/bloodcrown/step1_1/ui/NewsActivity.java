package com.bloodcrown.step1_1.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bloodcrown.step1_1.R;
import com.bloodcrown.step1_1.persenter.NewsPersenter;

public class NewsActivity extends AppCompatActivity implements IBaseView {

    private TextView tx_content;
    private Button btn_getNews;
    private NewsPersenter mNewsPersenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tx_content = (TextView) findViewById(R.id.content);
        btn_getNews = (Button) findViewById(R.id.title);

        mNewsPersenter = new NewsPersenter();
        mNewsPersenter.setmIBaseView(this);

        btn_getNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mNewsPersenter != null) {
                    mNewsPersenter.update();
                }
            }
        });
    }

    @Override
    public void update(String data) {
        tx_content.setText(data);
    }
}
