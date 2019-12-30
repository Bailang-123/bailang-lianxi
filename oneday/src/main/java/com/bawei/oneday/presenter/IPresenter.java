package com.bawei.oneday.presenter;

import com.bawei.oneday.base.BasePresenter;
import com.bawei.oneday.contart.IContart;
import com.bawei.oneday.model.IModel;

public class IPresenter extends BasePresenter {
    private IContart.MyModel myModel;
    @Override
    protected void initData() {
        myModel = new IModel();
    }

    @Override
    public void PresenterInfo(String url) {
        myModel.ModelInfo(url, new IContart.Models() {
            @Override
            public void onSuccess(String url) {
                getView().onSuccess(url);
            }

            @Override
            public void onError(String error) {
                getView().onError(error);
            }
        });
    }
}
