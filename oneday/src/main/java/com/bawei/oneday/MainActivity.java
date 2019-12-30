package com.bawei.oneday;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.oneday.base.BaseActivity;
import com.bawei.oneday.base.BasePresenter;
import com.bawei.oneday.bean.JsonBean;
import com.bawei.oneday.presenter.IPresenter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    @BindView(R.id.recycler_view01)
    RecyclerView recyclerView01;
    private MyAdapter myAdapter;
    private List<JsonBean.ResultBean> list = new ArrayList<>();

    @Override
    protected void startPresenter() {
        mpresenter.PresenterInfo("http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword=%E6%89%8B%E6%9C%BA&page=1&count=20");

    }

    @Override
    protected BasePresenter getPresenter() {
        return new IPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(String url) {
        Log.e("bailang",url);
        Gson gson = new Gson();
        JsonBean jsonBean = gson.fromJson(url, JsonBean.class);
        List<JsonBean.ResultBean> result = jsonBean.getResult();
        list.addAll(result);
        recyclerView01.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(list,this);
        recyclerView01.setAdapter(myAdapter);
        myAdapter.setCliCent(new MyAdapter.setCliCent() {
            @Override
            public void onCliCent(int item) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onError(String error) {

    }
}
