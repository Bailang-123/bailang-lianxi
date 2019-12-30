package com.bawei.oneday.base;

import com.bawei.oneday.contart.IContart;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends IContart.MyView> implements IContart.MyPresenter {
    private WeakReference<V> weakReference;

    public BasePresenter() {
        initData();
    }

    public void onAttchView(V view) {
        weakReference = new WeakReference<>(view);
    }

    public void onDraAttchView() {
        if (weakReference != null) {
            weakReference.clear();
            weakReference = null;
        }
    }

    public V getView() {
        return weakReference.get();
    }

    protected abstract void initData();
}
