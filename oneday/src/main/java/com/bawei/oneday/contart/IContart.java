package com.bawei.oneday.contart;

public interface IContart {
    interface MyModel {
        void ModelInfo(String url, Models models);
    }

    interface MyView {
        void onSuccess(String url);

        void onError(String error);
    }

    interface MyPresenter {
        void PresenterInfo(String url);
    }

    interface Models {
        void onSuccess(String url);

        void onError(String error);
    }
}
