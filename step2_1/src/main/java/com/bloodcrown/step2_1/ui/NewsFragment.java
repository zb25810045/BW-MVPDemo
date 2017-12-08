package com.bloodcrown.step2_1.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bloodcrown.step2_1.R;
import com.bloodcrown.step2_1.base.fragment.BaseFragment;
import com.bloodcrown.step2_1.persenter.NewsFragmentPersenter;

/**
 * Created by zbzbgo on 2017/12/3.
 */

public class NewsFragment extends BaseFragment<NewsFragment, NewsFragmentPersenter> implements INewsView {

    private View rootView;
    private TextView tx_content;
    private Button btn_getNews;

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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tx_content = (TextView) rootView.findViewById(R.id.content22);
        btn_getNews = (Button) rootView.findViewById(R.id.title11);

        btn_getNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPersenter().update();
                getPersenter().getView().showNewsList();
            }
        });
    }

}
