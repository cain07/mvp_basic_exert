package com.basic.mvp.base;

import java.lang.ref.WeakReference;


// Presenter基类
public abstract class BasePresenter<V extends BaseView,M extends BaseModel,CONTRACT> {

    public M m;

    // 绑定View层弱引用
    private WeakReference<V> weakReference;

    public BasePresenter() {
        this.m = getModel();
    }

    public void bindView(V v) {
        weakReference = new WeakReference<>(v);
    }

    public void unBindView() {

        if (weakReference != null){
            weakReference.clear();
            weakReference = null;
            System.gc();
        }

    }

    // 泛型 初始化了 view
    // 获取View，P -- V
    public V getView(){
        if (weakReference != null){
            return weakReference.get();
        }
        return null;
    }

    // 获取子类具体契约（Model层和View层协商的共同业务）
    public abstract CONTRACT getContract();

    public abstract M getModel();


}
