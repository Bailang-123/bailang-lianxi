package com.bawei.oneday.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.oneday.contart.IContart;

import butterknife.ButterKnife;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IContart.MyView {
    public P mpresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(layoutId()!=0){
            setContentView(layoutId());
            ButterKnife.bind(this);
            initView();
            mpresenter = getPresenter();
            mpresenter.onAttchView(this);
            startPresenter();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mpresenter.onDraAttchView();
    }

    protected abstract void startPresenter();

    protected abstract P getPresenter();

    protected abstract void initView();

    protected abstract int layoutId();
}
