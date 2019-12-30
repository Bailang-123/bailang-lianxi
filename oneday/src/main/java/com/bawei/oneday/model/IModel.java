package com.bawei.oneday.model;

import com.bawei.oneday.contart.IContart;
import com.bawei.oneday.util.NetUtil;

public class IModel implements IContart.MyModel {
    @Override
    public void ModelInfo(String url, IContart.Models models) {
        NetUtil.getInstance().doGet(url, new NetUtil.MyMallBack() {
            @Override
            public void onSuccess(String url) {
                models.onSuccess(url);
            }

            @Override
            public void onError(String error) {
                models.onError(error);
            }
        });
    }
}
