package com.basic.mvp.base;

// 接收到P层交给它的需求（基类）


public abstract class BaseModel<P extends BasePresenter,CONTRACT> {


    public P p;

    public BaseModel(P p) {
        this.p = p;
    }

    public abstract CONTRACT getContract();


}
